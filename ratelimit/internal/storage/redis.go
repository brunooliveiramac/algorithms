package storage

import (
	"context"
	"github.com/redis/go-redis/v9"
	"strconv"
	"time"
)

type RedisClient struct {
	Client *redis.Client
}

type RedisStore struct {
	Client *redis.Client
}

func NewRedisStore(client *redis.Client) Store {
	return &RedisStore{Client: client}
}

func (r *RedisStore) IncrementWithExpiry(ctx context.Context, key string, expiry time.Duration) (int, error) {
	result, err := r.Client.Incr(ctx, key).Result()
	if err != nil {
		return 0, err
	}
	r.Client.Expire(ctx, key, expiry)
	return int(result), nil
}

func (r *RedisStore) SetConfig(ctx context.Context, key string, value int) error {
	_, err := r.Client.Set(ctx, key, value, 0).Result()
	return err
}

func (r *RedisStore) GetConfig(ctx context.Context, key string) (int, error) {
	result, err := r.Client.Get(ctx, key).Result()
	if err == redis.Nil {
		return 0, err // Retorna erro se a chave não existe
	} else if err != nil {
		return 0, err // Retorna erro se ocorrer algum erro ao acessar o Redis
	}

	// Converte o resultado de string para int
	value, err := strconv.Atoi(result)
	if err != nil {
		return 0, err // Retorna erro se não conseguir converter o valor
	}

	return value, nil
}
