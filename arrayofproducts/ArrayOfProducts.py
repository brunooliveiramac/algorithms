def arrayOfProducts(array):
    toReturn = []
    for i in range(len(array)):
        aux = 1
        for j in range(len(array)):
            if j != i:
                aux *= array[j]
        toReturn.append(aux)
    return toReturn


if __name__ == '__main__':
    array = [5, 1, 4, 2]
    print(arrayOfProducts(array))
