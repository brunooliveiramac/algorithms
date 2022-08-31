# This is an input class. Do not edit.
class BinaryTree:
    def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right


def binaryTreeDiameter(tree):
    return getTreeInfo(tree).diameter


def getTreeInfo(tree):
    if tree is None:
        return TreeInfo(0, 0)

    leftTreeInfo = getTreeInfo(tree.left)
    rightTreeInfo = getTreeInfo(tree.right)

    longestPath = leftTreeInfo.height + rightTreeInfo.height
    maxDiameterSoFar = max(leftTreeInfo.diameter, rightTreeInfo.diameter)
    currentDiameter = max(longestPath, maxDiameterSoFar)
    currentHeight = 1 + max(leftTreeInfo.height, rightTreeInfo.height)
    return TreeInfo(currentDiameter, currentHeight)


class TreeInfo:
    def __init__(self, diameter, height):
        self.diameter = diameter
        self.height = height


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
