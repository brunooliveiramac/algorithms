package middleware

import (
	"net/http"
	"rate-limiter/internal/ratelimiter"
)

func RateLimitMiddleware(rateLimiter *ratelimiter.Client) func(http.Handler) http.Handler {
	return func(next http.Handler) http.Handler {
		return http.HandlerFunc(func(w http.ResponseWriter, r *http.Request) {
			clientIP := r.RemoteAddr
			token := r.Header.Get("API_KEY")

			if !rateLimiter.AllowRequest(clientIP, token) {
				http.Error(w, "You have reached the maximum number of requests or actions allowed within a certain time frame", http.StatusTooManyRequests)
				return
			}
			next.ServeHTTP(w, r)
		})
	}
}
