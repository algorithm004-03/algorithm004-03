"""
第十一题：77. 组合
https://leetcode-cn.com/problems/combinations/
"""

"""
解法一：回溯
"""


class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        def backtrack(first=1, curr=[]):
            if len(curr) == k:
                output.append(curr[:])
            for i in range(first, n + 1):
                curr.append(i)
                backtrack(i + 1, curr)
                curr.pop()

        output = []
        backtrack()
        return output