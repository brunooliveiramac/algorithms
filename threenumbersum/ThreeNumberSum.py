def threeNumberSum(array, target_sum):
    array.sort()
    array_to_return = []
    for index, element in enumerate(array):
        threeNumberSumHelper(array, target_sum, index + 1, len(array) - 1, element, array_to_return)
    return array_to_return


def threeNumberSumHelper(array, target_sum, left_pointer, right_pointer, element, array_to_return):
    if right_pointer <= left_pointer:
        return array_to_return

    sum = element + array[left_pointer] + array[right_pointer]

    if sum == target_sum:
        triplets = [element, array[left_pointer], array[right_pointer]]
        array_to_return.append(triplets)
        return threeNumberSumHelper(array, target_sum, left_pointer + 1, right_pointer - 1, element, array_to_return)
    if sum > target_sum:
        return threeNumberSumHelper(array, target_sum, left_pointer, right_pointer - 1, element, array_to_return)
    if sum < target_sum:
        return threeNumberSumHelper(array, target_sum, left_pointer + 1, right_pointer, element, array_to_return)


if __name__ == '__main__':
    print(threeNumberSum([12, 3, 1, 2, -6, 5, -8, 6], 0))
