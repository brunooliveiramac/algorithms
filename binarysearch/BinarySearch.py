def binarySearch(array, target):
    middle = (0 + len(array) - 1)/2   # -1 pq quer a ultima posição
    potentialMatch = array[middle]

    if (array[potentialMatch] == target):
        return potentialMatch
    if (array[potentialMatch] > target):
        middle = ((middle + 1) + len(array) - 1) / 2
    if (array[potentialMatch] < target):
        middle = (0 + (middle + 1)) / 2

    pass
