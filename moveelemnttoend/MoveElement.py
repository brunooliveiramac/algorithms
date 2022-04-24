# Solution 1
def moveElementToEnd(array, toMove):
    indexOne = 0
    indexTwo = len(array) - 1
    while indexOne < len(array) - 1 and indexTwo > 0 and indexTwo > indexOne:
        if toMove == array[indexOne]:
            if array[indexTwo] != toMove:
                array[indexOne] = array[indexTwo]
                array[indexTwo] = toMove
            else:
                indexOne -= 1
            indexOne += 1
            indexTwo -= 1
        else:
            indexOne += 1
    return array

# Solution 2
def moveElementToEnd(array, toMove):
    indexOne = 0
    indexTwo = len(array) - 1
    while indexOne < indexTwo:
        while indexOne < indexTwo and array[indexTwo] == toMove:
            indexTwo -= 1
        if array[indexOne] == toMove:
            array[indexOne], array[indexTwo] = array[indexTwo], array[indexOne]
        indexOne += 1
    return array

if __name__ == '__main__':
    array = [2, 1, 2, 2, 2, 3, 4, 2]
    toMove = 2

    print(moveElementToEnd(array, toMove))
