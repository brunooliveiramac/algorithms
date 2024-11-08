package main

func main() {

	ch := make(chan string, 1)
	// se o buffer fosse de 1, ele teria que esperar o valor ser lido, pra poder jogar o proximo valor
	// agora eu consigo jogar muitos e ler simultaneamente

	ch <- "Hello"
	println(<-ch)

	ch <- "World"

	println(<-ch)

}
