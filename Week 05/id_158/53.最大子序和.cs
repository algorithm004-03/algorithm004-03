/*
 * @lc app=leetcode.cn id=53 lang=csharp
 *
 * [53] 最大子序和
 */

// @lc code=start
using System;
using System.Linq;

public class Solution {
    public int MaxSubArray(int[] nums) {
        int[] dp =nums;
        for (int i = 1; i < nums.Length; i++)
        {
            dp[i] = Math.Max(nums[i],nums[i]+dp[i-1]);
        }
        return dp.Max();
    }
}
// @lc code=end

