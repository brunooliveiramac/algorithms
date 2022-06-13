class BST:
    def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right


def reconstructBst(preOrderTraversalValues):
    bst = BST(preOrderTraversalValues[0])
    for index in range(1, len(preOrderTraversalValues)):
        reconstructBstHelper(preOrderTraversalValues[index], bst)
    return bst


def traversal(bst):
    if bst is None:
        return

    if bst is not None:
        print(bst.value)

    if bst.left is not None:
        traversal(bst.left)

    if bst.right is not None:
        traversal(bst.right)


def reconstructBstHelper(value, bst):
    if value < bst.value:
        if bst.left is None:
            bst.left = BST(value)
        else:
            reconstructBstHelper(value, bst.left)
    else:
        if bst.right is None:
            bst.right = BST(value)
        else:
            reconstructBstHelper(value, bst.right)


if __name__ == '__main__':
    bst = reconstructBst([10, 4, 2, 1, 5, 17, 19, 18])
    print(bst)

    # a = BST(10)
    # b = BST(4)
    # c = BST(2)
    # d = BST(1)
    # e = BST(5)
    # f = BST(17)
    # g = BST(19)
    # h = BST(18)
    #
    # a.left = b
    # a.right = f
    #
    # b.left = c
    # b.right = e
    #
    # c.left = d
    #
    # f.right = g
    # g.left = h
    #
    # traversal(a)
