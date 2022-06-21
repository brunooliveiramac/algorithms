# This is an input class. Do not edit.
class BinaryTree:
    def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right


def binaryTreeDiameter(tree):
    # Write your code here.
    return -1


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

    a.left = c
    a.right = b

    c.left = g
    g.left = h
    h.left = i

    c.right = d
    d.right = e
    e.right = f

