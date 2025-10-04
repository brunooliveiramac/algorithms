package main

import "strconv"

type Solution struct{}

func NewSolution() Solution {
	return Solution{}
}

func (s *Solution) Encode(strs []string) string {
	result := ""

	for _, n := range strs {
		slen := len(n)
		result += strconv.Itoa(slen)
		result += "#"
		result += n
	}

	println(result)
	return result
}

func (s *Solution) Decode(st string) []string {
	var arr []string

	for _, str := range st {
		slen := str
	}

	return arr
}

func main() {

	solution := NewSolution()
	arr := []string{"neet", "code", "love", "you"}

	encode := solution.Encode(arr)
	solution.Decode(encode)
}
