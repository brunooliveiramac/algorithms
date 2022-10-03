def maxSubsetSumNoAdjacent(array):
    if not len(array):
        return 0
    elif len(array) == 1:
        return array[0]
    aux_arr = array[:]
    aux_arr[1] = max(array[0], array[1])
    for index in range(2, len(array)):
        aux_arr[index] = max(aux_arr[index - 1], aux_arr[index - 2] + aux_arr[index])
    return max(aux_arr)


if __name__ == '__main__':
    print(maxSubsetSumNoAdjacent([7, 10, 12, 7, 9, 14]))
