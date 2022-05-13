def mergeOverlappingIntervals(intervals):
    i = 0

    intervals.sort()

    while i < len(intervals):

        second = intervals[i][1]
        j = i + 1

        while j < len(intervals):

            next_first = intervals[j][0]
            next_second = intervals[j][1]

            if second >= next_first:
                if second >= next_second:
                    intervals.pop(j)
                    j -= 1
                else:
                    # Second        = Next Second
                    intervals[i][1] = next_second
                    second = next_second
                    intervals.pop(j)
                    j -= 1
            else:
                break

            j += 1

        i += 1

    return intervals


if __name__ == '__main__':
    intervals = [[2, 3], [4, 5], [6, 7], [8, 9], [1, 10]]
    print(mergeOverlappingIntervals(intervals))
