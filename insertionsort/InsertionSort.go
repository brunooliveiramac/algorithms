package main

import "fmt"

type Item struct {
	Pos   int
	Value string
}

func main() {

	pairs := []Item{
		{Pos: 5, Value: "apple"},
		{Pos: 2, Value: "banana"},
		{Pos: 9, Value: "cherry"},
	}

	var output [][]Item

	for i := 0; i < len(pairs); i++ {

		var helperList []Item
		for x := 0; x < len(pairs); x++ {
			helperList = append(helperList, pairs[x])
		}
		for j := i + 1; j < len(pairs); j++ {
			if pairs[i].Pos > pairs[j].Pos {
				pairs[i], pairs[j] = pairs[j], pairs[i]
			}
		}

		output = append(output, helperList)
		helperList = nil
	}

	fmt.Println(output)

}
