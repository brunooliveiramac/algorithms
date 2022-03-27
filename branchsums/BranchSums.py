# This is the class of the input root. Do not edit it.
class BinaryTree:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None


def calculateBranchSums(root, currentSum, sums):
    if root is None:
        return

    newSum = currentSum + root.value

    if root.left is None and root.right is None:
        sums.append(newSum)

    calculateBranchSums(root.left, newSum, sums)
    calculateBranchSums(root.right, newSum, sums)


def branchSums(root):
    # Write your code here.
    sums = []
    calculateBranchSums(root, 0, sums)
    return sums




if __name__ == '__main__':
    first = BinaryTree(1)
    second = BinaryTree(1)
    third = BinaryTree(1)
    fourth = BinaryTree(2)
    fifth = BinaryTree(2)
    sixth = BinaryTree(2)

    first.left = second
    second.left = third
    second.right = fourth
    fourth.left = fifth
    fourth.right = sixth

    sum = branchSums(first)
    print(sum)

