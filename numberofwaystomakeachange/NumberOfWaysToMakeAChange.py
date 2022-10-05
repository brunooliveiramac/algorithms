def numberOfWaysToMakeChange(n, denoms):
    ways = []

    for i in range(n):
        ways.append(i)

    for i in range(len(denoms)):
        if denoms[i] <= ways[i]:
            ways[i] = ways[i] + ways[i - 1]
    return ways


if __name__ == '__main__':
    print(numberOfWaysToMakeChange(6, [1, 5]))
