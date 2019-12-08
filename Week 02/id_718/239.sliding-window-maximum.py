#
# @lc app=leetcode id=239 lang=python3
#
# [239] Sliding Window Maximum
#

# @lc code=start
from collections import deque
class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        ret = []
        if not nums: return ret
        window = deque()
        for i, v in enumerate(nums):
            if i >= k and window[0] <= (i-k):
                window.popleft()
            while window and nums[window[-1]] <= v:
                window.pop()
            window.append(i)
            if i >= k - 1:
                ret.append(nums[window[0]])
        return ret
# @lc code=end

