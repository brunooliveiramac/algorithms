class BinaryTree:
    def __init__(self, value, left=None, right=None, parent=None):
        self.value = value
        self.left = left
        self.right = right
        self.parent = parent


def inOrderTraverse(tree, arr):
    if tree.left is not None:
        inOrderTraverse(tree.left, arr)

    arr.append(tree)

    if tree.right is not None:
        inOrderTraverse(tree.right, arr)

    return arr


def findSuccessor(tree, node):
    arr = []
    inOrderTraverse(tree, arr)

    for idx, currentNode in enumerate(arr):
        if currentNode != node:
            continue

        if idx == len(arr) - 1:
            return None

        return arr[idx + 1]



if __name__ == '__main__':
    a = BinaryTree(1)
    b = BinaryTree(2)
    c = BinaryTree(3)
    d = BinaryTree(4)
    e = BinaryTree(5)
    f = BinaryTree(6)

    a.left = b
    a.right = c

    b.parent = a
    b.left = d
    b.right = e

    c.parent = a

    d.parent = b
    d.left = f

    e.parent = b

    f.parent = d


    print(findSuccessor(a, e).value)

