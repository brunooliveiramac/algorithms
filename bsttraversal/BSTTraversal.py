class BST:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None


def inOrderTraverse(tree, array):
    if tree.left is not None:
        inOrderTraverse(tree.left, array)

    array.append(tree.value)

    if tree.right is not None:
        inOrderTraverse(tree.right, array)
    return array


def preOrderTraverse(tree, array):
    array.append(tree.value)

    if tree.left is not None:
        preOrderTraverse(tree.left, array)
    if tree.right is not None:
        preOrderTraverse(tree.right, array)

    return array


def postOrderTraverse(tree, array):
    if tree.left is not None:
        postOrderTraverse(tree.left, array)
    if tree.right is not None:
        postOrderTraverse(tree.right, array)

    if tree is not None:
        array.append(tree.value)
    return


if __name__ == '__main__':
    a = BST(10)
    b = BST(5)
    c = BST(15)
    d = BST(2)
    e = BST(5)
    f = BST(1)
    g = BST(15)
    h = BST(22)

    a.left = b
    a.right = c

    c.right = h

    b.left = d
    b.right = e

    d.left = f

    arr = []
    inOrderTraverse(a, arr)

    print(arr)
