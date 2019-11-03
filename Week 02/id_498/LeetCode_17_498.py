from typing import Union


class Solution:
    def letterCombinations(self, digits: str) -> Union[str, list]:
        """

        """
        phone_number_dict = {'2': ['a', 'b', 'c'],
                             '3': ['d', 'e', 'f'],
                             '4': ['g', 'h', 'i'],
                             '5': ['j', 'k', 'l'],
                             '6': ['m', 'n', 'o'],
                             '7': ['p', 'q', 'r', 's'],
                             '8': ['t', 'u', 'v'],
                             '9': ['w', 'x', 'y', 'z']}
        # 如果有这个字符串
        if not digits:
            return ''
        # 结果集
        list1 = []

        def backtrack(result, next_digits):
            # 出口
            # 每一次都会缩减一个字符，知道缩减为空字符
            if len(next_digits) == 0:
                list1.append(result)
                return
            # 逻辑
            # i is letter, j is '2' '3'
            for i in phone_number_dict[next_digits[0]]:
                # 下一层 取消了首位
                backtrack(result + i, next_digits[1:])

        backtrack('', digits)
        return list1


s = Solution()
print(s.letterCombinations('23'))
