package main

import "sort"

func longestConsecutive(nums []int) int {
	sort.Ints(nums)
	var result []int

	for i := range nums {
		if i+1 <= len(nums)-1 {
			if (nums[i+1] - nums[i]) == 0 {
				continue
			}
		}

		result = append(result, nums[i])

		if i+1 > len(nums)-1 {
			break
		}
		if (nums[i+1] - nums[i]) > 1 {
			break
		}
	}

	return len(result)
}

func main() {
	nums := []int{9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6}
	println(longestConsecutive(nums))
}
