package main

import (
	"flag"
	"fmt"
	"log"
	"net/http"
	"sync"
	"time"
)

func main() {
	// Parâmetros CLI
	url := flag.String("url", "", "URL do serviço a ser testado")
	requests := flag.Int("requests", 100, "Número total de requests")
	concurrency := flag.Int("concurrency", 10, "Número de chamadas simultâneas")
	flag.Parse()

	if *url == "" {
		fmt.Println("URL não pode ser vazio")
		return
	}

	if *requests <= 0 {
		fmt.Println("Número de requests deve ser maior que zero")
		return
	}

	if *concurrency <= 0 {
		fmt.Println("Número de concorrência deve ser maior que zero")
		return
	}

	fmt.Printf("Testando %s com %d requests e concorrência de %d\n", *url, *requests, *concurrency)

	// Configurações de HTTP Client
	var netTransport = &http.Transport{
		MaxIdleConnsPerHost: *concurrency, // Limita a concorrência por host
	}
	var httpClient = &http.Client{
		Transport: netTransport,
		Timeout:   10 * time.Second, // 10 segundos de timeout para cada request
	}

	// Canal para controle de concorrência
	concurrentGoroutines := make(chan struct{}, *concurrency)

	var wg sync.WaitGroup
	wg.Add(*requests)

	// Contadores
	var totalDuration time.Duration
	var successCount int
	statusCodes := make(map[int]int)

	for i := 0; i < *requests; i++ {
		concurrentGoroutines <- struct{}{}
		go func() {
			defer wg.Done()
			startTime := time.Now()

			resp, err := httpClient.Get(*url)
			duration := time.Since(startTime)
			totalDuration += duration

			if err == nil {
				statusCodes[resp.StatusCode]++
				if resp.StatusCode == 200 {
					successCount++
				}
				resp.Body.Close()
			} else {
				log.Printf("Erro ao fazer request: %v", err)
			}

			<-concurrentGoroutines
		}()
	}

	wg.Wait()

	// Exibindo resultados
	fmt.Printf("Tempo total de execução: %v\n", totalDuration)
	fmt.Printf("Total de requests realizados: %d\n", *requests)
	fmt.Printf("Requests com status 200: %d\n", successCount)
	fmt.Println("Distribuição de status HTTP:")
	for status, count := range statusCodes {
		fmt.Printf("Status %d: %d vezes\n", status, count)
	}
}
