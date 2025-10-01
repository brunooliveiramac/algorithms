package main

func longestConsecutive(nums []int) int {
	numSet := make(map[int]struct{})
	for _, num := range nums {
		numSet[num] = struct{}{}
	}

	longest := 0
	for num := range numSet {
		if _, found := numSet[num-1]; !found {
			length := 1
			for {
				if _, exists := numSet[num+length]; exists {
					length++
				} else {
					break
				}
			}
			if length > longest {
				longest = length
			}
		}
	}
	return longest
}

func main() {
	nums := []int{9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6}
	println(longestConsecutive(nums))
}
