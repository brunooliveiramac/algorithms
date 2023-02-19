def containsDuplicate(nums: []) -> bool:
    hash_set = set()

    for number in nums:
        if number in hash_set:
            return True
        hash_set.add(number)
    return False


if __name__ == '__main__':
    print(containsDuplicate([1,2,3,3,4]))