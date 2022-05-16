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


class BST:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

    def insert(self, value):
        insertNode(self, value)
        return self

    def contains(self, value):
        # Write your code here.
        pass

    def remove(self, value):
        # Write your code here.
        # Do not edit the return statement of this method.
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

    a.insert(12)

    print(f.left.value)
    print(f.right.value)

