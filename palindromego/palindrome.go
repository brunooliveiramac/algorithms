package main

func main() {

	println(isPalindrome("arara"))
}

func isPalindrome(word string) bool {
	left, right := 0, len(word)-1
	for left < right {
		if word[left] != word[right] {
			return false
		}
		left++
		right--
	}
	return true
}
