#
# @lc app=leetcode id=283 lang=python3
#
# [283] Move Zeroes
#

# @lc code=start
class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        i = 0 # slow pointer
        for j, v in enumerate(nums):
            if v != 0:
                nums[i] = nums[j]
                if i != j: nums[j] = 0
                i += 1
# @lc code=end

