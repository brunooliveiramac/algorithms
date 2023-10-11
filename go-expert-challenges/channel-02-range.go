package main

func main() {
	ch := make(chan string)

	go publish(ch)

	reader(ch)
}

func publish(ch chan<- string) {
	for i := 0; i < 10; i++ {
		ch <- "Hello World!"
	}
	close(ch)
}

func reader(ch <-chan string) {
	for {
		msg, ok := <-ch
		if !ok {
			break
		}
		println(msg)
	}
}
