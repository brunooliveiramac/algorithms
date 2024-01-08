package main

import (
	"encoding/json"
	"fmt"
	"net/http"
	"sync"
)

// Como o cacnel lida com synchonization e race condition?
//  - Basicamente aqui estou usando um canal com buffer, uma filq.. Entao, eu vou adicionando, e lendo a fila, se tiver varios consumidores
//    eles vao consumindo de forma paralela. Caso eu tivesse uma channel sem buffer, eu teria que ter um consumidor por vez, e isso nao
//    seria paralelo.
//  - O sync.WaitGroup é usado para esperar que todas as goroutines terminem de executar, para que o programa não termine antes de todas as
//    goroutines terminarem de executar.
func main() {

	ceps := []string{"13098-426", "18940-000"}
	var wg sync.WaitGroup
	wg.Add(len(ceps))

	ch := make(chan string, len(ceps))
	for _, cep := range ceps {
		go fetchAddr(fmt.Sprintf("https://cdn.apicep.com/file/apicep/%s.json", cep), ch, &wg)
	}

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
