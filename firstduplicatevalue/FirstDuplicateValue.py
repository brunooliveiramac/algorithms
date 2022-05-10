def firstDuplicateValue(array):
    for i in range(len(array)):
        for j in range(len(array)):
            if i != j:
                if array[i] == array[j]:
                    return array[i]

    return -1


if __name__ == '__main__':
    print(firstDuplicateValue([2, 1, 5, 2, 3, 3, 4])) # 2
