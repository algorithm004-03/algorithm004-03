#
# @lc app=leetcode id=169 lang=python3
#
# [169] Majority Element
#

# @lc code=start
class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        # Morris voting
        candidate, cnt = None, 0
        for num in nums:
            if cnt == 0:
                candidate = num
            cnt += (1 if num == candidate else -1)
        return candidate
        
# @lc code=end

