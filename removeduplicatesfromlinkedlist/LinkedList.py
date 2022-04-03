class LinkedList:
    def __init__(self, value):
        self.value = value
        self.next = None

    def __str__(self):
        return str(self.value)


def removeDuplicatesFromLinkedList(linkedList):
    current = linkedList

    while current is not None:
        nextDistinct = current.next
        while nextDistinct is not None and nextDistinct.value == current.value:
            nextDistinct = nextDistinct.next
        current.next = nextDistinct
        current = nextDistinct
    return linkedList


if __name__ == '__main__':
    g = LinkedList(4)
    f = LinkedList(3)
    f.next = g
    e = LinkedList(3)
    e.next = f
    d = LinkedList(3)
    d.next = e
    c = LinkedList(2)
    c.next = d
    b = LinkedList(2)
    b.next = c
    a = LinkedList(1)
    a.next = b

    obj = removeDuplicatesFromLinkedList(a)

    while obj is not None:
        print(obj.value)
        obj = obj.next
