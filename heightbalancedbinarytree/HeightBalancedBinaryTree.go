package main

import "math"

type BinaryTree struct {
	Value int

	Left  *BinaryTree
	Right *BinaryTree
}

func HeightBalancedBinaryTreeHelper(tree *BinaryTree, balanced *[1]bool) float64 {
	if tree == nil {
		return 0
	}
	leftHeight := HeightBalancedBinaryTreeHelper(tree.Left, balanced)
	rightHeight := HeightBalancedBinaryTreeHelper(tree.Right, balanced)

	if math.Abs(leftHeight-rightHeight) > 1 {
		balanced[0] = false
	}
	height := math.Max(leftHeight, rightHeight) + 1
	return height
}

func HeightBalancedBinaryTree(tree *BinaryTree) bool {
	var balanced [1]bool
	balanced[0] = true
	HeightBalancedBinaryTreeHelper(tree, &balanced)
	return balanced[0]

	return true
}

func main() {

	g := BinaryTree{
		Value: 8,
		Left:  nil,
		Right: nil,
	}
	f := BinaryTree{
		Value: 7,
		Left:  nil,
		Right: nil,
	}
	e := BinaryTree{
		Value: 6,
		Left:  nil,
		Right: nil,
	}
	d := BinaryTree{
		Value: 5,
		Left:  &f,
		Right: &g,
	}
	c := BinaryTree{
		Value: 4,
		Left:  nil,
		Right: nil,
	}
	b := BinaryTree{
		Value: 3,
		Left:  nil,
		Right: &e,
	}
	a := BinaryTree{
		Value: 2,
		Left:  &c,
		Right: &d,
	}
	root := BinaryTree{
		Value: 1,
		Left:  &a,
		Right: &b,
	}

	print(HeightBalancedBinaryTree(&root))
}
