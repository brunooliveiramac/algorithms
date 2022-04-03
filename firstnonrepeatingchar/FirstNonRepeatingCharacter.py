def firstNonRepeatingCharacter(string):
    dict = {}
    for str in string:
        try:
            frequency = dict[str]
            dict[str] = frequency + 1
        except:
            dict[str] = 1

    for key, value in dict.items():
        if value == 1:
            return key

    return -1


if __name__ == '__main__':
    string = "abcdcaf"
    print(firstNonRepeatingCharacter(string))
