package entrypoint

import (
	"encoding/json"
	"github.com/go-chi/chi/v5"
	"net/http"
	"strings"

	"github.com/weather-api/internal/entity"
)

type WebCEPHandler struct {
	CEPRepository     entity.CEPRepository
	WeatherRepository entity.WeatherRepository
	ApiKey            string
}

func NewCepHandler(cepRepo entity.CEPRepository, weatherRepo entity.WeatherRepository, api_key string) *WebCEPHandler {
	return &WebCEPHandler{
		CEPRepository:     cepRepo,
		WeatherRepository: weatherRepo,
		ApiKey:            api_key,
	}
}

func (h *WebCEPHandler) Get(w http.ResponseWriter, r *http.Request) {
	cep := chi.URLParam(r, "cep")
	if !h.CEPRepository.IsValid(cep) {
		http.Error(w, "invalid zipcode", http.StatusUnprocessableEntity)
		return
	}

	cepData, err := h.CEPRepository.Get(cep)
	if err != nil {
		http.Error(w, "Error fetching CEP data", http.StatusInternalServerError)
		return
	}

	if strings.Contains(string(cepData), "erro") {
		http.Error(w, "can not find zipcode", http.StatusNotFound)
		return
	}

	cepEntity, err := h.CEPRepository.Convert(cepData)
	if err != nil {
		http.Error(w, "Error converting CEP data", http.StatusInternalServerError)
		return
	}

	weatherData, err := h.WeatherRepository.Get(cepEntity.Localidade, h.ApiKey)
	if err != nil {
		http.Error(w, "Error fetching weather data", http.StatusInternalServerError)
		return
	}

	weatherResponse, err := h.WeatherRepository.ConvertToWeatherResponse(weatherData)
	if err != nil {
		http.Error(w, "Error converting weather data", http.StatusInternalServerError)
		return
	}

	weather, err := h.WeatherRepository.ConvertToWeather(weatherResponse)
	if err != nil {
		http.Error(w, "Error converting weather response", http.StatusInternalServerError)
		return
	}

	w.Header().Set("Content-Type", "application/json")
	json.NewEncoder(w).Encode(weather)
}
