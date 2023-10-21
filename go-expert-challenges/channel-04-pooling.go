package main

import "fmt"

func main() {

	ch := make(chan string)

	const employee = 2

	for i := 0; i < employee; i++ {
		go func(employeeID int) {
			for p := range ch {
				fmt.Println("employee : received :", p)
			}
			fmt.Println("employee : received shutdown signal")
		}(employee)
	}
}
