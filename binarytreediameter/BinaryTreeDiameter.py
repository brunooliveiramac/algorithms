# This is an input class. Do not edit.
class BinaryTree:
    def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right


def left(tree, count):
    if tree.left is not None:
        count += 1
        return left(tree.left, count)
    return count


def right(tree, count):
    if tree.right is not None:
        count += 1
        return right(tree.right, count)
    return count


def binaryTreeDiameterHelper(tree, count, arr):
    leftResult = 0
    rightResult = 0
    if tree is not None:
        if tree.left is not None:
            leftResult = left(tree, count)

        if tree.right is not None:
            rightResult = right(tree, count)

        arr.append(leftResult + rightResult)

        binaryTreeDiameterHelper(tree.left, count, arr)
        binaryTreeDiameterHelper(tree.right, count, arr)

    return arr, count


def binaryTreeDiameter(tree):
    count = 0
    arr = []
    arr, count = binaryTreeDiameterHelper(tree, count, arr)
    return max(arr)


if __name__ == '__main__':
    # a = BinaryTree(1)
    # b = BinaryTree(2)
    # c = BinaryTree(3)
    # d = BinaryTree(4)
    # e = BinaryTree(5)
    # f = BinaryTree(6)
    # g = BinaryTree(7)
    # h = BinaryTree(8)
    # i = BinaryTree(9)
    #
    # a.left = c
    # a.right = b
    #
    # c.left = g
    # g.left = h
    # h.left = i
    #
    # c.right = d
    # d.right = e
    # e.right = f


    a = BinaryTree(3)
    b = BinaryTree(10)
    c = BinaryTree(1)

    a.right = b

    b.left = c


    result = binaryTreeDiameter(a)
    print(result)
