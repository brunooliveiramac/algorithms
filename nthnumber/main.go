package main

import "fmt"

func findNthNumber(n int) int {
	// 1 = 1, 2 = 2, 3 = 3, 4 = 4, 5 = last four sum
	base := []int{1, 2, 3, 4}

	for len(base) < n {
		next := base[len(base)-1] + base[len(base)-2] + base[len(base)-3] + base[len(base)-4]
		base = append(base, next)
	}

	return base[n-1]

}

func main() {
	var n int
	fmt.Scan(&n)

	result := findNthNumber(n)

	fmt.Println(result)
}
