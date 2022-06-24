# This is an input class. Do not edit.
class BinaryTree:
    def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right


def binaryTreeDiameterHelper(tree, count, arr):
    if tree.left is not None:
        count += 1
        binaryTreeDiameterHelper(tree.left, count, arr)

    if tree.right is not None:
        count += 1
        binaryTreeDiameterHelper(tree.right, count, arr)

    else:
        arr.append(count)
        count = 0

    return arr, count


def binaryTreeDiameter(tree):
    count = 0
    arr = []
    arr, count = binaryTreeDiameterHelper(tree, count, arr)
    return max(arr)


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

    result = binaryTreeDiameter(a)
    print(result)
