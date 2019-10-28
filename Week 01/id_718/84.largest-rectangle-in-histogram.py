#
# @lc app=leetcode id=84 lang=python3
#
# [84] Largest Rectangle in Histogram
#

# @lc code=start
from collections import deque
class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        stack = deque([-1])
        ret = 0
        heights.append(0)
        # increasing stack
        for i in range(len(heights)):
            while heights[i] < heights[stack[-1]]:
                h = heights[stack.pop()]
                w = i - stack[-1] - 1
                ret = max(ret, h * w)
            stack.append(i)
        return ret
# @lc code=end

