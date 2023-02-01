# Write a function to find the longest common prefix string amongst an array of strings.
# If there is no common prefix, return an empty string ""

# Example 1:
# Input: strs = ["flower","flow","flight"]
#   Output: "fl"
#
# Example 2:
#   Input: strs = ["dog","racecar","car"]
# Output: ""
#   Explanation: There is no common prefix among the input strings.

# Example 1:
# Input: strs = ["flower","flow","flight", "dog", "dogo"]
#   Output: "fl"

# flow
# flower
# flight
# dog

def longestPrefix(strs):

    word = strs[0]
    longest_prefix = ""

    for index_letter, letter in enumerate(word):

        # f
        for index_word, word in enumerate(strs):
            # flow, flower
            if letter != word[index_letter]:
                return longest_prefix

        longest_prefix += letter

    return longest_prefix



#
# for index_word, word in enumerate(strs):
#     print("next: ")



if __name__ == '__main__':
    strs = ["flower","flow","flight"]
    print(longestPrefix(strs))
