class BST:
    def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right


def findKthLargestValueInBst(tree, k):
    arr = []

    ordered_array = inOrderTraverse(tree, arr)

    position = len(ordered_array) - k

    return arr[position]


def inOrderTraverse(tree, array):
    if tree.left is not None:
        inOrderTraverse(tree.left, array)

    array.append(tree.value)

    if tree.right is not None:
        inOrderTraverse(tree.right, array)

    return array


if __name__ == '__main__':
    a = BST(15)
    b = BST(5)
    c = BST(2)
    d = BST(5)
    e = BST(1)
    f = BST(3)

    g = BST(20)
    h = BST(17)
    i = BST(22)

    a.left = b
    a.right = g

    g.left = h
    g.right = i

    b.left = c
    b.right = d

    c.left = e
    c.right = f

    print(findKthLargestValueInBst(a, 3))
