from typing import List


class Solution:
    """
    This solution strictly follows the recursion template
    Time complexity is O(3^n), exponential
    """

    def __init__(self):
        """
        initiate with a result to store
        letter_map dict to store the mapping between number and letters
        """
        self.res = []
        self.letter_map = {
            0: " ",
            1: "",
            2: "abc",
            3: "def",
            4: "ghi",
            5: "jkl",
            6: "mno",
            7: "pqrs",
            8: "tuv",
            9: "wxyz"
        }

    def letterCombinations(self, digits: str) -> List[str]:
        if len(digits) == 0:
            return self.res
        self._letter_combo(0, len(digits), digits, "")
        return self.res

    def _letter_combo(self, curr_level, max_level, digits, curr_str):
        """

        :param curr_level: current digit
        :param max_level: length of the digits
        :param digits: digits
        :param curr_str: current letter string
        :return:
        """
        # for each curr_level, print out the curr_str
        print("current level is {a} : current str is {b}".format(a=curr_level,
                                                                 b=curr_str))

        # terminator
        if curr_level >= max_level:
            self.res.append(curr_str)
            return

        # process the current logic
        # get the current digit
        digit = digits[curr_level]
        # make sure the digit is valid
        assert (0 <= int(digit) <= 9) and (int(digit) != 1)

        # get the letters of the digit
        letters = self.letter_map[int(digit)]

        # drill down for each letter
        for letter in letters:
            # print out the details for each recursion
            print("digits[{a}] = {b}, letter {c} is used".format(a=curr_level,
                                                                 b=digit,
                                                                 c=letter))
            self._letter_combo(curr_level + 1, max_level, digits,
                               curr_str + letter)

        # after finishing recursion at each level, revert to the last level
        return


def test():
    sol = Solution()
    res = sol.letterCombinations("5678")
    print(res)


if __name__ == '__main__':
    test()
