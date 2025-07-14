package main

//Two Number Sum
//
//Write a function that takes in a non-empty array of distinct integers and an integer representing a target sum. If any two numbers in the input array sum up to the target sum, the function should return them in an array, in any order. If no two numbers sum up to the target sum, the function should return an empty array.
//
//Note that the target sum has to be obtained by summing two different integers in the array; you can't add a single integer to itself in order to obtain the target sum.
//
//You can assume that there will be at most one pair of numbers summing up to the target sum.
//
//Sample Input
//
//makefile
//Copy code
//array = [3, 5, -4, 8, 11, 1, -1, 6]
//targetSum = 10
//Sample Output
//[-1, 11] // the numbers could be in reverse order

// O(n²)
// brute force
func TwoNumberSum(array []int, target int) []int {
	sum := make([]int, 0)
out:
	for i := 0; i < len(array); i++ {
		for j := 0; j < len(array); j++ {
			if i != j {
				if array[i]+array[j] == target {
					sum = append(sum, array[i])
					sum = append(sum, array[j])
					break out
				}
			}
		}
	}
	return sum
}

// o(n) time
// o(n) space
func TwoSum(nums []int, taget int) []int {
	prevMap := make(map[int]int)

	for i, n := range nums {
		diff := taget - n
		if j, found := prevMap[diff]; found {
			return []int{j, i}
		}
		// n = value
		// i = index
		prevMap[n] = i
	}
	return []int{}
}

func main() {
	print(TwoNumberSum([]int{3, 5, -4, 8, 11, 1, -1, 6}, 10))
}
