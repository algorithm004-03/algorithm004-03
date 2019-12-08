/*
思路
DP 算法解决
dp[i]表示以i位置结束的最大和子数组的和的数值
显然有:

dp[i-1]负数,
    dp[i] = nums[i], i位置自己作为一个子数组
dp[i-1]非负
    dp[i] = nums[i] + dp[i-1], i位置根前面连一起组成子数组

最后找所有dp[i]中最大值

 */

class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int dp = nums[0];
        int maxVal = dp;
        for (int i = 1; i < nums.length; i++) {
            dp = (dp >= 0) ? dp + nums[i] : nums[i];
            maxVal = Math.max(maxVal, dp);
        }

        return maxVal;
    }
}