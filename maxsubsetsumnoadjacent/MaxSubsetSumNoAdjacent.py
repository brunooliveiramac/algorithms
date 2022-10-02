def maxSubsetSumNoAdjacent(array):
    aux_arr = []

    for index in range(len(array)):

        if index >= 2:
            max_at_current_position = max(array[index - 1], array[index - 2] + array[index])
            aux_arr.append(max_at_current_position)
        else:
            aux_arr.append(array[index])
    print(aux_arr)
    return max(aux_arr)


if __name__ == '__main__':
    print(maxSubsetSumNoAdjacent([7, 10, 12, 7, 9, 14]))
