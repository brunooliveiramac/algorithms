def isAnagram(s: str, t: str) -> bool:
    s_sorted = sorted(s)
    t_sorted = sorted(t)

    return s_sorted == t_sorted

if __name__ == '__main__':
    print(isAnagram("anagram", "nagaram"))