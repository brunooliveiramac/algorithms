def bubbleSort(array):
    isSorted = False
    while not isSorted:
        isSorted = True
        for i in range(len(array) - 1):
            if array[i] > array[i + 1]:
                swap(i, i + 1, array)
                isSorted = False

    return array

def swap(currently, next, array):
    array[currently], array[next] = array[next], array[currently]


if __name__ == '__main__':

    sorted = bubbleSort([5, 2, 4, 2, 1, 6, 9, 3, 7])

    for x in sorted:
        print(x)
