package ratelimiter

import (
	"context"
	"fmt"
	"os"
	"rate-limiter/internal/storage"
	"strconv"
	"time"
)

type Client struct {
	store             storage.Store
	requestLimitIP    int
	requestLimitToken int
	blockTimeIP       time.Duration
	blockTimeToken    time.Duration
}

func NewClient(store storage.Store) *Client {
	requestLimitIP, _ := strconv.Atoi(os.Getenv("REQUEST_LIMIT_IP"))
	blockTimeIP, _ := strconv.Atoi(os.Getenv("BLOCK_TIME_IP"))

	if requestLimitIP == 0 {
		requestLimitIP = 10
	}

	if blockTimeIP == 0 {
		blockTimeIP = 60
	}

	return &Client{
		store:          store,
		requestLimitIP: requestLimitIP,
		blockTimeIP:    time.Duration(blockTimeIP) * time.Second,
	}
}

func (c *Client) AllowRequest(clientIP, token string) bool {
	ctx := context.Background()
	ipIdentifier := fmt.Sprintf("ip:%s", clientIP)

	// Default values for IP rate limiting
	limit := c.requestLimitIP
	blockTime := c.blockTimeIP

	// Check and apply Token-specific rate limiting if a token is provided
	if token != "" {

		customIPLimit, err := c.store.GetConfig(ctx, fmt.Sprintf("config:%s:limit", token))
		customIPBlockTime, err := c.store.GetConfig(ctx, fmt.Sprintf("config:%s:blockTime", token))

		// Convert block time to time.Duration, assuming it's stored as seconds in Redis
		tokenBlockTimeDuration := time.Duration(customIPBlockTime) * time.Second

		tokenCount, err := c.store.IncrementWithExpiry(ctx, token, tokenBlockTimeDuration)
		if err != nil || tokenCount > customIPLimit {
			return false
		}
	}
	// Check and apply IP-specific rate limiting
	ipCount, err := c.store.IncrementWithExpiry(ctx, ipIdentifier, blockTime)
	if err != nil {
		panic(err)
	}

	if ipCount > limit {
		return false
	}

	return true
}
