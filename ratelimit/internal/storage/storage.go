package storage

import (
	"context"
	"time"
)

type Store interface {
	IncrementWithExpiry(ctx context.Context, key string, expiry time.Duration) (int, error)

	GetConfig(ctx context.Context, key string) (int, error)

	SetConfig(ctx context.Context, key string, value int) error
}
