#
# @lc app=leetcode id=20 lang=python3
#
# [20] Valid Parentheses
#

# @lc code=start
from collections import deque
class Solution:
    def isValid(self, s: str) -> bool:
        dic = {")":"(", "]":"[", "}":"{"}
        stack = deque()
        for c in s:
            if c not in dic:
                stack.append(c)
            elif not stack or dic[c] != stack.pop():
                return False
        return not stack        
# @lc code=end

