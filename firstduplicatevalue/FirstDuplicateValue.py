def firstDuplicateValue(array):
    my_dict = dict()

    for i in range(len(array)):
        if array[i] in my_dict:
            return array[i]
        my_dict[array[i]] = array[i]
    return -1


if __name__ == '__main__':
    print(firstDuplicateValue([3, 1, 3, 1, 1, 4, 4]))  # 2
