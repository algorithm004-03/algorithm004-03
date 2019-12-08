#
# @lc app=leetcode id=15 lang=python3
#
# [15] 3Sum
#

# @lc code=start
class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        ret = []
        n = len(nums)
        nums.sort()
        for i in range(0, n - 1):
            if nums[i] > 0: break
            if i != 0 and nums[i] == nums[i-1]: continue
            l, r = i + 1, n - 1
            target = 0 - nums[i]
            while l < r:
                if nums[l] + nums[r] == target:
                    ret.append([nums[i], nums[l], nums[r]])
                    l += 1
                    r -= 1
                elif nums[l] + nums[r] < target:
                    l += 1
                else:
                    r -= 1
                while i + 1 < l < r and nums[l] == nums[l-1]: l += 1
                while l < r and r < n -1 and nums[r] == nums[r+1]: r -= 1
        return ret
# @lc code=end

