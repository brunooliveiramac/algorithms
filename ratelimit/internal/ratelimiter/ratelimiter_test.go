package ratelimiter

import (
	"context"
	"fmt"
	"github.com/stretchr/testify/assert"
	"testing"
	"time"

	"github.com/stretchr/testify/mock"
)

// MockStore is a mock type for the Store interface
type MockStore struct {
	mock.Mock
}

func (m *MockStore) IncrementWithExpiry(ctx context.Context, key string, expiry time.Duration) (int, error) {
	args := m.Called(ctx, key, expiry)
	return args.Int(0), args.Error(1)
}

func (m *MockStore) GetConfig(ctx context.Context, key string) (int, error) {
	args := m.Called(ctx, key)
	return args.Int(0), args.Error(1)
}

func (m *MockStore) SetConfig(ctx context.Context, key string, value int) error {
	args := m.Called(ctx, key, value)
	return args.Error(0)
}

func TestAllowRequest(t *testing.T) {
	mockStore := new(MockStore)
	client := NewClient(mockStore)

	tests := []struct {
		name           string
		clientIP       string
		token          string
		mockIncrement  []interface{} // responses for IncrementWithExpiry calls
		mockGetConfig  []interface{} // responses for GetConfig calls
		expectedResult bool
	}{
		{
			name:           "IP under limit without token",
			clientIP:       "192.168.1.1",
			mockIncrement:  []interface{}{4, nil}, // IncrementWithExpiry returns count 4, no error
			expectedResult: true,
		},
		{
			name:           "Token rate limiting with token over limit",
			clientIP:       "192.168.1.1",
			token:          "token123",
			mockIncrement:  []interface{}{1, nil, 11, nil},   // First for IP, second for token
			mockGetConfig:  []interface{}{10, nil, 300, nil}, // token limit and block time
			expectedResult: false,
		},
	}

	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			// Setting up the mock responses
			mockStore.On("IncrementWithExpiry", mock.Anything, fmt.Sprintf("ip:%s", tt.clientIP), mock.AnythingOfType("time.Duration")).Return(tt.mockIncrement[0:2]...)
			if tt.token != "" {
				mockStore.On("GetConfig", mock.Anything, fmt.Sprintf("config:%s:limit", tt.token)).Return(tt.mockGetConfig[0], tt.mockGetConfig[1])
				mockStore.On("GetConfig", mock.Anything, fmt.Sprintf("config:%s:blockTime", tt.token)).Return(tt.mockGetConfig[2], tt.mockGetConfig[3])
				mockStore.On("IncrementWithExpiry", mock.Anything, tt.token, mock.AnythingOfType("time.Duration")).Return(tt.mockIncrement[2:4]...)
			}

			// Executing the test
			result := client.AllowRequest(tt.clientIP, tt.token)
			assert.Equal(t, tt.expectedResult, result)

			mockStore.Calls = nil // Reset the calls after each test to ensure clean state

		})
	}
}
