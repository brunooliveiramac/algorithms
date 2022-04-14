# Uses python3
import sys


def get_change(m):
    return change(m, 0)


def change(value, count):
    if (value / 10) > 1:
        count = (value // 10) + count
        result = value % 10
        return change(result, count)
    if (value / 5) > 1:
        count = (value // 5) + count
        result = value % 5
        return change(result, count)
    if (value / 1) == value:
        count = (value // 1) + count
        return count




if __name__ == '__main__':
    m = int(sys.stdin.read())
    print(get_change(m))
