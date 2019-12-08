#
# @lc app=leetcode id=1 lang=python3
#
# [1] Two Sum
#

# @lc code=start
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dic = dict()
        for i, v in enumerate(nums):
            if target - v in dic:
                return i, dic[target - v]
            dic[v] = i
        return []
        
# @lc code=end

