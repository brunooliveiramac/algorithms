package main

type BinaryTree struct {
	Value int

	Left  *BinaryTree
	Right *BinaryTree
}

func HeightBalancedBinaryTree(tree *BinaryTree) bool {
	if tree == nil {
		return false
	}

	if tree.Left != nil && tree.Right != nil {
		result := tree.Right.Value - tree.Left.Value
		if result != 1 {
			return false
		}
	}
	HeightBalancedBinaryTree(tree.Left)
	HeightBalancedBinaryTree(tree.Right)

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