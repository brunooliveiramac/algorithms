# This is an input class. Do not edit.
class BST:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None


def validateBstHelper(tree, bools):
    if tree.right is not None:
        if tree.value > tree.right.value:
            bools.append(False)
        validateBstHelper(tree.right, bools)
    if tree.left is not None:
        if tree.value < tree.left.value:
            bools.append(False)
        validateBstHelper(tree.left, bools)
    bools.append(True)


def validateBst(tree):
    bools = []
    validateBstHelper(tree, bools)
    return False not in bools

if __name__ == '__main__':
    a = BST(10)
    b = BST(5)
    c = BST(15)
    d = BST(12)

    a.right = c
    a.left = b
    b.right = d

    print(validateBst(a))
    pass
