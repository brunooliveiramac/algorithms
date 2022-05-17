# Do not edit the class below except for
# the insert, contains, and remove methods.
# Feel free to add new properties and methods
# to the class.
def insertNode(self, value):
    if self is None:
        return

    if value >= self.value:
        if self.right is None:
            self.right = BST(value)
            return
        insertNode(self.right, value)
    else:
        if self.left is None:
            self.left = BST(value)
            return
        insertNode(self.left, value)


def removeNode(self, value):
    if self is None:
        return

    if value > self.value:
        if self.right is not None:
            if self.right.value == value:
                self.right = None
                return
        removeNode(self.right, value)
    else:
        if self.left is not None:
            if self.left.value == value:
                self.left = None
                return
        removeNode(self.left, value)


def containsNode(self, value):
    if self is None:
        return

    if self.value == value:
        return True

    if value > self.value:
        return containsNode(self.right, value)
    else:
        return containsNode(self.left, value)

    return False


class BST:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

    def insert(self, value):
        insertNode(self, value)
        return self

    def contains(self, value):
        return containsNode(self, value)

    def remove(self, value):
        removeNode(self, value)
        return self


if __name__ == '__main__':
    a = BST(10)
    b = BST(5)
    c = BST(15)

    d = BST(2)
    e = BST(5)

    f = BST(13)
    g = BST(22)

    h = BST(14)
    i = BST(1)

    a.left = b
    a.right = c

    b.left = d
    b.right = e

    d.left = i

    c.left = f
    c.right = g

    f.right = h

    a.insert(5)

    print(f.left.value)
    print(f.right.value)

    a.remove(12)

    print(f.left)
    print(f.right.value)

    print(a.contains(5))