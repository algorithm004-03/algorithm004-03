#
# @lc app=leetcode id=70 lang=python3
#
# [70] Climbing Stairs
#

# @lc code=start
class Solution:
    def climbStairs(self, n: int) -> int:
        # rolling array
        x, y = 1, 0
        for _ in range(n):
            x, y = x + y, x
        return x

'''
class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # two pointers
        j = 0
        for i, v in enumerate(nums):
            if v:
                nums[i], nums[j] = nums[j], nums[i]
                j += 1
'''
# @lc code=end

