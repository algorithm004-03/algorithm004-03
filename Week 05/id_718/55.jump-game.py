#
# @lc app=leetcode id=55 lang=python3
#
# [55] Jump Game
#

# @lc code=start
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n, reach = len(nums), 0
        for i, jump in enumerate(nums):
            if reach >= n - 1:
                return True
            if i > reach:
                return False
            reach = max(reach, i + jump)
# @lc code=end

