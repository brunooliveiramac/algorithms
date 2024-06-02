package main

import (
	"encoding/json"
	"github.com/gorilla/mux"
	"github.com/joho/godotenv"
	"github.com/redis/go-redis/v9"
	"log"
	"net/http"
	"os"
	"rate-limiter/internal/middleware"
	"rate-limiter/internal/ratelimiter"
	"rate-limiter/internal/storage"
)

func main() {
	err := godotenv.Load()
	if err != nil {
		log.Fatal("Error loading .env file")
	}

	redisClient := redis.NewClient(&redis.Options{
		Addr: os.Getenv("REDIS_ADDRESS"),
	})

	store := storage.NewRedisStore(redisClient)
	rateLimiter := ratelimiter.NewClient(store)

	r := mux.NewRouter()
	r.Use(middleware.RateLimitMiddleware(rateLimiter))
	r.HandleFunc("/config/token", configureToken(store)).Methods("POST")

	r.HandleFunc("/", func(w http.ResponseWriter, r *http.Request) {
		w.WriteHeader(http.StatusOK)
		w.Write([]byte("Welcome to the rate limited application!"))
	}).Methods("GET")

	log.Println("Server starting on port 8080...")
	log.Fatal(http.ListenAndServe(":8080", r))
}

func configureToken(store storage.Store) http.HandlerFunc {
	return func(w http.ResponseWriter, r *http.Request) {
		var config struct {
			Token        string `json:"token"`
			RequestLimit int    `json:"requestLimit"`
			BlockTime    int    `json:"blockTime"`
		}

		if err := json.NewDecoder(r.Body).Decode(&config); err != nil {
			http.Error(w, "Invalid request body", http.StatusBadRequest)
			return
		}

		ctx := r.Context()
		if err := store.SetConfig(ctx, "config:"+config.Token+":limit", config.RequestLimit); err != nil {
			http.Error(w, "Failed to set request limit", http.StatusInternalServerError)
			return
		}
		if err := store.SetConfig(ctx, "config:"+config.Token+":blockTime", config.BlockTime); err != nil {
			http.Error(w, "Failed to set block time", http.StatusInternalServerError)
			return
		}

		w.WriteHeader(http.StatusOK)
		w.Write([]byte("Token configuration saved successfully"))
	}
}
