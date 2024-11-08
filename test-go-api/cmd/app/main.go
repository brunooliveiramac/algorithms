package main

import (
	"github.com/api-test/internal/core"
	"github.com/api-test/internal/repository"
)

func main() {

	repository := repository.NewOrderRepository()
	useCase := core.NewOrderSaveUseCase(repository)
	
}
