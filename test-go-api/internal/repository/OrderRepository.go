package repository

import "github.com/api-test/internal/entity"

type OrderRepository struct{}

func NewOrderRepository() entity.OrderDataProvider {
	return &OrderRepository{}
}

func (o2 OrderRepository) Save(order entity.Order) (o entity.Order, err error) {
	//TODO implement me
	panic("implement me")
}
