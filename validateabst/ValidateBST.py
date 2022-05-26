# This is an input class. Do not edit.
class BST:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None


def validateBstHelper(tree, bools, parent=None):
    if tree.right is not None:
        if tree.value > tree.right.value:
            bools.append(False)
        if parent is not None and parent.left == tree:
            if tree.right.value >= parent.value:
                bools.append(False)
        validateBstHelper(tree.right, bools, tree)
    if tree.left is not None:
        if tree.value < tree.left.value:
            bools.append(False)
        validateBstHelper(tree.left, bools, tree)
    bools.append(True)


def validateBst(tree):
    bools = []
    validateBstHelper(tree, bools)
    return False not in bools


if __name__ == '__main__':
    a = BST(10)
    b = BST(15)
    c = BST(22)
    d = BST(5)
    e = BST(5)
    f = BST(11)
    g = BST(2)
    h = BST(1)

    a.left = d
    a.right = b
    b.right = c
    d.left = g
    d.right = e
    e.right = f
    g.left = h

    print(validateBst(a))
