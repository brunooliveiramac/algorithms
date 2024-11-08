package main

import (
	"context"
	"encoding/json"
	"fmt"
	"net/http"
	"sync"
)

// Como o canal lida com synchonization e race condition?
//   - Basicamente aqui estou usando um canal com buffer, uma filq.. Entao, eu vou adicionando, e lendo a fila, se tiver varios consumidores
//     eles vao consumindo de forma paralela. Caso eu tivesse uma channel sem buffer, eu teria que ter um consumidor por vez, e isso nao
//     seria paralelo.
//   - O sync.WaitGroup é usado para esperar que todas as goroutines terminem de executar, para que o programa não termine antes de todas as
//     goroutines terminarem de executar.
func main() {

	ceps := []string{"13098-426", "18940-000"}
	var wg sync.WaitGroup
	wg.Add(len(ceps))

	ch := make(chan string, len(ceps))
	for _, cep := range ceps {
		go fetchAddr(fmt.Sprintf("https://cdn.apicep.com/file/apicep/%s.json", cep), ch, &wg)
	}

	// close the channel when all goroutines are done
	// wrap wg.Wait() and close(ch) in a goroutine so that the main function can continue to the for result := range ch loop without waiting.
	go func() {
		wg.Wait()
		close(ch)
	}()

	// aqui, o canal vai sendo consumido equanto mensagens forem sendo adicionadas
	for result := range ch {
		fmt.Println(result)
	}

}

func fetchAddr(url string, ch chan<- string, wg *sync.WaitGroup) {
	defer wg.Done()

	resp, err := http.Get(url)
	if err != nil {
		ch <- fmt.Sprint(err)
		return
	}
	defer resp.Body.Close()

	var result map[string]interface{}

	if err := json.NewDecoder(resp.Body).Decode(&result); err != nil {
		ch <- fmt.Sprint(err)
		return
	}

	fmt.Println(result)
	ch <- fmt.Sprintf("response: %s ", result)
}

func (i *Service) getPDFBytes(ctx context.Context, pdfURIs []string, userID string) (chan []byte, handler.Error) {
	query := map[string]string{
		"client.id": userID,
	}

	// Use a semaphore to limit the number of goroutines running in parallel
	sem := make(chan struct{}, i.mBackInvoice.Config.MaxParallelProcessing)

	var wg sync.WaitGroup
	wg.Add(len(pdfURIs))

	// Use a buffered channel to hold the file bytes downloaded
	filesBytes := make(chan []byte, len(pdfURIs))

	// Create goroutines to download each PDF file
	for _, pdfURI := range pdfURIs {
		// Acquire a semaphore slot before starting the goroutine
		// Aqui limitamos a quantidade de goroutines que podem ser executadas ao mesmo tempo
		// Usando o semaforo, que nada mais é que um canal com buffer
		// Como o canal tem buffer, ele vai adicionando as goroutines, e quando o buffer estiver cheio, ele vai esperar
		// uma goroutine terminar para adicionar outra
		// A go routine vai ser executada em paralelo, mas o semaforo vai limitar a quantidade de goroutines que podem ser executadas
		// ao mesmo tempo
		// Dessa forma, o canal é usado para sincronizar as goroutines
		sem <- struct{}{}

		go func(pdfURI string) {
			defer func() {
				// Release the semaphore slot when the goroutine is finished
				<-sem
				wg.Done()
			}()

			pdf, err := i.mBackInvoice.GetInvoicePDF(ctx, pdfURI, query, nil)
			if err != nil {
				log.Error(ctx, fmt.Sprintf("error trying to download Invoice PDF. InvoiceURL: [%s], err: [%s]", pdfURI, err))
			}
			// Sends each file bytes to channel
			filesBytes <- pdf
		}(pdfURI)
	}

	wg.Wait()
	close(filesBytes)

	return filesBytes, nil
}
