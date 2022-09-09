package main

type BinaryTree struct {
	Value int

	Left  *BinaryTree
	Right *BinaryTree
}

func HeightBalancedBinaryTree(tree *BinaryTree) bool {
	// Write your code here.
	return false
}

func main() {
	root := BinaryTree{
		Value: 1,
		Left:  nil,
		Right: nil,
	}
	print(HeightBalancedBinaryTree(&root))
}