package main

import (
	"encoding/json"
	"fmt"
	"net/http"
	"time"
)

func main() {
	ch := make(chan string)
	cep := "13098-426"
	go fetch(fmt.Sprintf("https://cdn.apicep.com/file/apicep/%s.json", cep), ch, "API_1")
	go fetch(fmt.Sprintf("https://viacep.com.br/ws/%s/json/", cep), ch, "API_2")

	select {
	case result := <-ch:
		fmt.Println(result)
	case <-time.After(1 * time.Second):
		fmt.Println("Timeout")
	}
}

func fetch(url string, ch chan<- string, apiName string) {

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
	ch <- fmt.Sprintf("API: %s was faster", apiName)
}
