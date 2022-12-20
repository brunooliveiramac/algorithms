def numberOfWaysToMakeChange(n, denoms):
    ways = [1] + [0 for _ in range(n)]

    for idx, d in enumerate(denoms):
        for change in range(d, n + 1):
            if d <= change:
                ways[change] += ways[change - d]

    return ways[-1]

if __name__ == '__main__':
    print(numberOfWaysToMakeChange(6, [1, 5]))
