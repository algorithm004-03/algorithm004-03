class Solution(object):
    def lengthOfLIS(self, nums):
        """
        最长上升子序列: https://leetcode-cn.com/problems/longest-increasing-subsequence/submissions/
        
        :type nums: List[int]
        :rtype: int
        """
        # 定义dp[i]为 对于每个 k = 0..i - 1，nums[0..k]中的最长子序列包含上nums[i]也成为最长子序列的大小
        # 而最终的最长子序列就是dp[i]中的最大值
        if not nums:
            return 0
        dp = [1] * len(nums)
        for i in range(0, len(nums)):
            for k in range(0, i):
                if nums[i] > nums[k]:
                    dp[i] = max(dp[i], dp[k] + 1)
        return max(dp)
                
