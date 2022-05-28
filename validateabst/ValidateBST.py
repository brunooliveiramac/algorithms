# This is an input class. Do not edit.
class BST:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None


def validateBstHelper(tree, bools, min=None, max=None):
    if tree.value < min or tree.value >= max:
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
    b = BST(9)
    c = BST(9)
    d = BST(5)
    e = BST(15)
    f = BST(13)
    g = BST(22)
    h = BST(10)

    a.right = e
    a.left = b
    b.left = d
    b.right = c
    e.right = g
    e.left = f
    d.right = h
    print(validateBst(a))
