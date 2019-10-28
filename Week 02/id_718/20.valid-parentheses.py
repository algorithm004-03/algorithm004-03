#
# @lc app=leetcode id=20 lang=python3
#
# [20] Valid Parentheses
#

# @lc code=start
from collections import deque
class Solution:
    def isValid(self, s: str) -> bool:
        m = {")": "(", "]":"[", "}":"{"}
        stack = deque()
        for c in s:
            if c not in m:
                stack.append(c)
            else:
                if not stack or stack.pop() != m[c]:
                    return False
        return not stack
# @lc code=end

