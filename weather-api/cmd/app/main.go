package main

import (
	"fmt"
	"github.com/weather-api/internal/infrastructure/entrypoint"
	"github.com/weather-api/internal/infrastructure/repository"
	"log"
	"net/http"
	"os"

	"github.com/weather-api/internal/infrastructure/entrypoint/api"
)

func main() {
	api := api.NewWebServer(":8080")

	cepRepo := repository.NewCEPRepository()
	weatherRepo := repository.NewWeatherRepository(&http.Client{})

	openWeathermapApiKey := os.Getenv("OPEN_WEATHERMAP_API_KEY")

	if openWeathermapApiKey == "" {
		log.Fatal("Please, provide the OPEN_WEATHERMAP_API_KEY environment variable; Make sure you provide a valid api-key, otherwise it will not be possible to get and convert weather data")
	}

	webCEPHandler := entrypoint.NewCepHandler(cepRepo, weatherRepo, os.Getenv("OPEN_WEATHERMAP_API_KEY"))
	webStatusHandler := entrypoint.NewWebStatusHandler()

	api.AddHandler("GET /cep/{cep}", webCEPHandler.Get)
	api.AddHandler("GET /status", webStatusHandler.Get)
	fmt.Println("Starting web server on port", ":8080")
	api.Start()
}
