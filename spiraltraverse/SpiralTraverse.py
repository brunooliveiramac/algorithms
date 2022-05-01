def spiralTraverse(array):
    startRow, endRow = 0, len(array) - 1
    startCol, endCol = 0, len(array[0]) - 1
    toReturn = []

    while startRow <= endRow and startCol <= endCol:
        for col in range(startCol, endCol + 1):
            toReturn.append(array[startRow][col])

        for row in range(startRow + 1, endRow + 1):
            toReturn.append(array[row][endCol])

        for col in reversed(range(startCol, endCol)):
            toReturn.append(array[endRow][col])

        for row in reversed(range(startRow + 1, endRow)):
            toReturn.append(array[row][startCol])

        startRow += 1
        startCol += 1
        endCol -= 1
        endRow -= 1

    return toReturn


if __name__ == '__main__':
    array = [
        [1, 2, 3, 4],
        [12, 13, 14, 5],
        [11, 16, 15, 6],
        [10, 9, 8, 7]
    ]

    print(spiralTraverse(array))
