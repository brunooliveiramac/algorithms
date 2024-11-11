package main

func maxArea(heights []int) int {
	area := 0
	left := 0
	right := len(heights) - 1

	for left < right {
		result := 0
		if heights[left] < heights[right] {
			result = heights[left] * (right - left)
			left++
		} else {
			result = heights[right] * (right - left)
			right--
		}
		if result > area {
			area = result
		}
	}
	return area
}

func main() {
	print(maxArea([]int{1, 8, 6, 2, 5, 4, 8, 3, 7}))
}
