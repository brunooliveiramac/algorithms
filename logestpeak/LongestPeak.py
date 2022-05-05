def longestPeak(array):
    walkPeak = 0
    longest = 0
    foundPeak = False
    for position in range(1, len(array) - 1):

        if array[position] < array[position + 1]:
            walkPeak += 1
            continue

        if array[position + 1] < array[position] > array[position - 1]:
            foundPeak = True

            walkPeak += 3

            if walkPeak > longest:
                longest = walkPeak

            walkPeak = 3

            continue

        if foundPeak:
            if array[position + 1] <= array[position]:
                walkPeak += 1

    if walkPeak > longest:
        longest = walkPeak

    return longest


if __name__ == '__main__':
    print(longestPeak([5, 4, 3, 2, 1, 2, 10, 12, -3, 5, 6, 7, 10]))
