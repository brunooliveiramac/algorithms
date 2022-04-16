# python3
import sys


def compute_min_refills(distance, tank, stops):
    num_refill, current_refill = 0, 0
    stops = [0] + stops + [distance]

    if distance <= tank:
        return 0

    while current_refill < len(stops) - 1:
        last_refill = current_refill

        while current_refill < len(stops) - 1:
            if stops[current_refill + 1] - stops[last_refill] > tank and (current_refill + 1) - last_refill == 1:
                return -1

            if stops[current_refill + 1] - stops[last_refill] <= tank:
                current_refill = current_refill + 1
            else:
                num_refill = num_refill + 1
                break

    return num_refill


if __name__ == '__main__':
    d, m, _, *stops = map(int, sys.stdin.read().split())
    print(compute_min_refills(d, m, stops))