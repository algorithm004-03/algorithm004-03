from typing import List


class Solution:
    @staticmethod
    def lengthOfLIS(nums: List[int]) -> int:
        if not nums:
            return 0
        dp = [1] * len(nums)
        for i in range(len(nums)):
            for j in range(i):
                # 如果要求非严格递增，将此行 '<' 改为 '<=' 即可。
                if nums[j] < nums[i]:
                    dp[i] = max(dp[i], dp[j] + 1)
        return max(dp)
