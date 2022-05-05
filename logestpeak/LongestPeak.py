def longestPeak(array):
    longest = 0
    i = 1

    while i < len(array) - 1:
        isPeak = array[i - 1] < array[i] > array[i + 1]

        if not isPeak:
            i += 1
            continue

        leftIndex = i - 2
        while leftIndex >= 0 and array[leftIndex] < array[leftIndex + 1]:
            leftIndex -= 1

        rightIndex = i + 2
        while rightIndex < len(array) and array[rightIndex] < array[rightIndex - 1]:
            rightIndex += 1

        current = rightIndex - leftIndex - 1
        longest = max(longest, current)
        i = rightIndex

    return longest

if __name__ == '__main__':
    print(longestPeak([5, 4, 3, 2, 1, 2, 10, 12, -3, 5, 6, 7, 10]))
