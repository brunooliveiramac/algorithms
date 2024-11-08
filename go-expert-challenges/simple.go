package main

func main() {
	ch := make(chan string)

	go func() {
		ch <- "ss"
	}()

	value := <-ch
	print(value)
}
