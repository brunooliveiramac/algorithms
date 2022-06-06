def minHeightBst(array):
    left = 0
    right = len(array) - 1
    middle = (left + right) // 2
    bst = BST(array[middle])

    dict = {middle: array[middle]}

    minHeightBstHelper(left, right, array, bst, dict)

    return bst


def minHeightBstHelper(left, right, array, bst, dict):
    middle = (left + right) // 2

    if right < left:
        return

    value = array[middle]

    if middle not in dict:
        bst.insert(value)
        dict[middle] = value


    minHeightBstHelper(left, middle - 1, array, bst, dict)

    minHeightBstHelper(middle + 1, right, array, bst, dict)


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
