package main

import "strconv"

type Solution struct{}

func NewSolution() Solution {
	return Solution{}
}

func (s *Solution) Encode(strs []string) string {
	if len(strs) == 1 && strs[0] == "" {
		return ""
	}
	if len(strs) == 0 {
		return "nil"
	}
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
	if st == "" {
		return []string{""}
	}
	if st == "nil" {
		return []string{}
	}
	var arr []string
	size := 0
	incrementSize := 0
	stringToBuild := ""

	for i, str := range st {
		if str == '#' {
			u := string(st[i-1])
			size, _ = strconv.Atoi(u)
		}
		if size != 0 && string(str) != "#" {
			if size != incrementSize {
				stringToBuild += string(str)
				incrementSize += 1
				if size == incrementSize && len(st) == i+1 {
					arr = append(arr, stringToBuild)
					println(stringToBuild)
				}
			} else {
				incrementSize = 0
				arr = append(arr, stringToBuild)
				println(stringToBuild)
				stringToBuild = ""
			}
		}
	}

	return arr
}

func main() {

	solution := NewSolution()
	arr := []string{""}

	encode := solution.Encode(arr)
	solution.Decode(encode)
}
