def invertBinaryTree(tree):
    if tree is None:
        invertBinaryTree(tree.left)
        invertBinaryTree(tree.right)

        tree.left, tree.right = tree.right, tree.left

# This is the class of the input binary tree.
class BinaryTree:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None


if __name__ == '__main__':
    a = BinaryTree(1)
    b = BinaryTree(2)
    c = BinaryTree(3)
    d = BinaryTree(4)
    e = BinaryTree(5)
    f = BinaryTree(6)
    g = BinaryTree(7)
    h = BinaryTree(8)
    i = BinaryTree(9)

    a.left = b
    a.right = c

    b.left = d
    b.right = e

    d.left = h
    d.right = i

    c.right = g
    c.left = f

    invertBinaryTree(a)
    print(a)
