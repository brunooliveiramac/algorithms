import sys


def smallestDifference(arrayOne, arrayTwo):
    arrayOne.sort()
    arrayTwo.sort()

    potentialArray = [sys.maxsize, 0]

    smallestDifferenceHelper(arrayOne, arrayTwo, potentialArray, 0, 0)

    return potentialArray


def smallestDifferenceHelper(arrayOne, arrayTwo, potentialArray, arrayOnePointer, arrayTwoPointer):
    if arrayOnePointer > len(arrayOne) - 1 or arrayTwoPointer > len(arrayTwo) - 1:
        return potentialArray

    if arrayOne[arrayOnePointer] == arrayTwo[arrayTwoPointer]:
        potentialArray[0] = arrayOne[arrayOnePointer]
        potentialArray[1] = arrayTwo[arrayTwoPointer]
        return potentialArray

    if arrayOne[arrayOnePointer] < arrayTwo[arrayTwoPointer] and arrayOnePointer <= len(arrayOne) - 1:
        checkPotentialArr(arrayOne, arrayOnePointer, arrayTwo, arrayTwoPointer, potentialArray)
        return smallestDifferenceHelper(arrayOne, arrayTwo, potentialArray, arrayOnePointer + 1, arrayTwoPointer)

    if arrayOne[arrayOnePointer] > arrayTwo[arrayTwoPointer] and arrayTwoPointer <= len(arrayTwo) - 1:
        checkPotentialArr(arrayOne, arrayOnePointer, arrayTwo, arrayTwoPointer, potentialArray)
        return smallestDifferenceHelper(arrayOne, arrayTwo, potentialArray, arrayOnePointer, arrayTwoPointer + 1)


def checkPotentialArr(arrayOne, arrayOnePointer, arrayTwo, arrayTwoPointer, potentialArray):
    if potentialArray:
        result = potentialArray[0] - potentialArray[1]
        current = arrayOne[arrayOnePointer] - arrayTwo[arrayTwoPointer]

        if abs(current) < abs(result):
            potentialArray[0] = arrayOne[arrayOnePointer]
            potentialArray[1] = arrayTwo[arrayTwoPointer]


if __name__ == '__main__':
    arrayOne = [10, 1000, 9124, 2142, 59, 24, 596, 591, 124, -123]
    arrayTwo = [-1441, -124, -25, 1014, 1500, 660, 410, 245, 530]

    print(smallestDifference(arrayOne, arrayTwo))
