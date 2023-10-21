package main

import (
	"fmt"
	"time"
)

func main() {
	ch := make(chan struct{})

	go func() {
		time.Sleep(1 * time.Second)
		close(ch)
		fmt.Println("close channel")
	}()

	_, ok := <-ch
	fmt.Println(ok)

	time.Sleep(2 * time.Second)
	fmt.Println("end")
}
