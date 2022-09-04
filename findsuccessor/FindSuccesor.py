class BinaryTree:
    def __init__(self, value, left=None, right=None, parent=None):
        self.value = value
        self.left = left
        self.right = right
        self.parent = parent


def inOrderTraverse(tree, map):
    if tree.left is not None:
        inOrderTraverse(tree.left, map)

    map[tree.value] = tree

    if tree.right is not None:
        inOrderTraverse(tree.right, map)

    return map


def findSuccessor(tree, node):
    map = {}
    inOrderTraverse(tree, map)
    element = map[node.value]

    if element.left is None and element.right is None:
        return element.parent.parent

    return None


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


    print(findSuccessor(a, e))
    #arr = []
    #print(inOrderTraverse(a, arr))
