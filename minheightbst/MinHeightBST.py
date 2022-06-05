def minHeightBst(array):
    left = 0
    right = len(array) - 1
    middle = (left + right) // 2
    bst = BST(array[middle])

    minHeightBstHelper(left, middle, array, bst, None)

    minHeightBstHelper(middle, right, array, bst, None)
    return bst

def minHeightBstHelper(left, right, array, bst, last_mid):

    middle = (left + right) // 2

    if last_mid is not None and middle == last_mid:
        return

    bst.insert(array[middle])

    minHeightBstHelper(left, middle, array, bst, middle)

    minHeightBstHelper(middle, right, array, bst, middle)


class BST:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

    def insert(self, value):
        if value < self.value:
            if self.left is None:
                self.left = BST(value)
            else:
                self.left.insert(value)
        else:
            if self.right is None:
                self.right = BST(value)
            else:
                self.right.insert(value)


if __name__ == '__main__':
    print(minHeightBst([1, 2, 5, 7, 10, 13, 14, 15, 22]))
