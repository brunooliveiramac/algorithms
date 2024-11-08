package weather

import (
	"github.com/weather-api/internal/entity"
)

type ValidateCEPInputDTO struct {
	CEP string
}

type ValidateCEPOutputDTO struct {
	IsValid bool
}

type ValidateCEPUseCase struct {
	CEPRepository entity.CEPRepository
}

func NewValidateCEPUseCase(cep_repository entity.CEPRepository) *ValidateCEPUseCase {
	return &ValidateCEPUseCase{
		CEPRepository: cep_repository,
	}
}

func (c *ValidateCEPUseCase) Execute(input ValidateCEPInputDTO) bool {
	return c.CEPRepository.IsValid(input.CEP)
}
