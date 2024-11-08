package core

import "github.com/api-test/internal/entity"

type OrderSaveUseCase struct {
	orderDataProvider entity.OrderDataProvider
}

func NewOrderSaveUseCase(orderDataProvider entity.OrderDataProvider) *OrderSaveUseCase {
	return &OrderSaveUseCase{
		orderDataProvider: orderDataProvider,
	}
}

func (os *OrderSaveUseCase) Execute(order entity.Order) (o entity.Order, err error) {
	order, er := os.orderDataProvider.Save(order)
	if er != nil {
		return entity.Order{}, er
	}
	return order, nil
}
