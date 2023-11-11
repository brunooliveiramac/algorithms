class DynamicArray:

    def __init__(self, capacity):
        self.capacity = capacity
        self.size = 0
        self.array = [0] * capacity

    def get(self, i):
        return self.array[i]

    def set(self, i, n):
        self.array[i] = n

    def pushback(self, n):
        if self.size == self.capacity:
            self.resize()
        self.array[self.size] = n
        self.size += 1

    def popback(self):
        self.size -= 1
        return self.array[self.size]

    def resize(self):
        self.capacity *= 2
        new_array = [0] * self.capacity
        for i in range(self.size):
            new_array[i] = self.array[i]
        self.array = new_array

    def getSize(self):
        return self.size

    def getCapacity(self):
        return self.capacity

if __name__ == '__main__':
    # Test your implementation here
    da = DynamicArray(2)
    da.set(0, 44)
    da.set(1, 45)
    da.resize()
    da.set(2, 46)

    print("Size: ", da.getSize())
    print("Capacity: ", da.getCapacity())
    print("Element at index 0: ", da.get(3))

