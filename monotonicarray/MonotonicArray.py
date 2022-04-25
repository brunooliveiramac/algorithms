def isMonotonic(array):
    if len(array) == 1 or len(array) == 0:
        return True
    direction = None

    result = True

    for i in range(len(array) - 1):
        if direction is None:
            if array[i] == array[i + 1]:
                direction = None

            if array[i] < array[i + 1]:
                direction = "UP"

            if array[i] > array[i + 1]:
                direction = "DOWN"

        if direction is not None:
            if direction == "UP":
                if array[i] > array[i + 1]:
                    result = False
            if direction == "DOWN":
                if array[i] < array[i + 1]:
                    result = False

    return result

if __name__ == '__main__':
    array = [-1, -5, -10, -1100, -1100, -1101, -1102, -9001]
    print(isMonotonic(array))
