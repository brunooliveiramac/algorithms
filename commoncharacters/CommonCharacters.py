def commonCharacters(strings):
    # Write your code here.
    result = set()
    string_map = {}
    for letter in strings[0]:
        for stgs in strings:
            if letter in stgs:
                string_map[letter] = 'x'
            else:
                string_map.pop(letter, None)
                break
    for key, value in string_map.items():
        result.add(key)

    return result
