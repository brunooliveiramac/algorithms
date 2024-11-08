package entity

type Order struct {
	ID     int
	Amount int
}

func (o *Order) GetTotal() int {
	return o.Amount
}

type OrderDataProvider interface {
	Save(order Order) (o Order, err error)
}
