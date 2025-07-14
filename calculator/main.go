package main

import (
	"fmt"
	"unicode"
)

func Calculate(expr string) (int, error) {
	numbers := []int{}

	var lastNum;
	var lastOperator
	for _, num := range expr {
		if unicode.IsDigit(num) {
			lastNum = int(num)
		} else {
			lastOperator =
		}
	}

	return 0, nil
}

func main() {
	tests := []string{
		"3+2*2",
		" 3/2 ",
		" 3+5 / 2 ",
		"10 - 2 * 3 + 1",
		"14-3/2",
		"4/0 + 1", // division by zero
		"",        // empty input
		"1 + + 2", // malformed input
	}

	for _, expr := range tests {
		res, err := Calculate(expr)
		if err != nil {
			fmt.Printf("Calculate(%q) error: %v\n", expr, err)
		} else {
			fmt.Printf("Calculate(%q) = %d\n", expr, res)
		}
	}
}
