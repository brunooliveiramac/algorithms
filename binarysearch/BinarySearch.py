# def binarySearch(array, target, leftPointer, rightPointer):
#     middle = (left_pointer + right_pointer) // 2  # -1 pq quer a ultima "posição"
#     potentialMatch = array[middle]
#
#     if (potentialMatch == target):
#         retorna a posição dele
#         return middle
#     if (potentialMatch > target):
#         middle = (left_pointer + (middle - 1)) // 2
#     if (potentialMatch < target):
#         middle = ((middle + 1) + rightPointer) // 2
#
#     pass

def binarySearch(arr, target, left_pointer, right_pointer):
    middle = (left_pointer + right_pointer) // 2  # -1 pq quer a ultima "posição"
    potentialMatch = arr[middle]

    if potentialMatch == target:
        return middle
    if potentialMatch > target:
        return binarySearch(arr, target, left_pointer, middle - 1)
    if potentialMatch < target:
        return binarySearch(arr, target, middle + 1, right_pointer)

    return -1


if __name__ == '__main__':
    array = [0, 1, 21, 33, 45, 45, 61, 71, 72, 73]
    result = binarySearch(array, 33, 0, len(array) - 1)
    print(result)
