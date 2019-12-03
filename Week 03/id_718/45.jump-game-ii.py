#
# @lc app=leetcode id=45 lang=python3
#
# [45] Jump Game II
#

# @lc code=start
class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        cur, cnt, pos = 0, 0, 0
        while cur < n - 1:
            cnt += 1
            pre = cur
            while pos <= pre:
                cur = max(cur, pos + nums[pos])
                pos += 1
        return cnt
# @lc code=end

