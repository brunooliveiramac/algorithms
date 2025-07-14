package main

func Semordnilap(words []string) [][]string {

	if len(words) == 0 {
		return [][]string{}
	}

	set := make(map[string]struct{})

	var pairs [][]string
	var reverserList []string

	for _, word := range words {
		reversed := reverse(word)
		if _, exists := set[reversed]; exists && reversed != word {
			pairs = append(pairs, []string{reversed, word})
		}
		set[word] = struct{}{}
		reverserList = append(reverserList, reversed)
	}

	return pairs
}

func reverse(word string) string {
	runes := []rune(word)
	for i, j := 0, len(runes)-1; i < j; i, j = i+1, j-1 {
		runes[i], runes[j] = runes[j], runes[i]
	}
	return string(runes)
}

func main() {

	words := []string{"abc", "def", "cba", "ghi", "fed", "ihg", "jkl"}

	result := Semordnilap(words)
	for _, pair := range result {
		println(pair[0], pair[1])
	}
}
