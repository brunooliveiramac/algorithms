package main

type Subsequence struct {
}

func IsValidSubsequence(array []int, sequence []int) bool {
	j := 0
	i := 0
	for i < len(array) && j < len(sequence) {
		if sequence[j] == array[i] {
			j++
		}
		i++
	}
	return j == len(sequence)
}

func main() {

	print(IsValidSubsequence([]int{5, 1, 22, 25, 6, -1, 8, 10}, []int{1, 6, -1, 9}))
}
