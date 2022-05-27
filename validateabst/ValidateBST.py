# This is an input class. Do not edit.
class BST:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None


def validateBstHelper(tree, bools, min=None, max=None):
    if tree.value < min  or tree.value >= max:
        bools.append(False)
    if tree.right is not None:
        validateBstHelper(tree.right, bools, tree.value, max)
    if tree.left is not None:
        validateBstHelper(tree.left, bools, min, tree.value)





def validateBst(tree):
    bools = []
    validateBstHelper(tree, bools, float("-inf"), float("inf"))
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
