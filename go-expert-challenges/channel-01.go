package main

import "fmt"

func main() {
	forever := make(chan string)

	go func() {
		forever <- "Hello World!"
	}()

	fmt.Sprintln(<-forever)
}
