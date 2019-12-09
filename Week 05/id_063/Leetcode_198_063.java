/*
思路
动态规划

dp[i]表示以i位置结尾的序列的最大和，考虑上一个位置，只可能是i-2 或者是 i-3
所以 dp[i] = max(dp[i-2], dp[i-3]) + nums[i]

 */


public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int maxVal = 0;
        int[] dp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if ((i == 0) || (i == 1)) {
                dp[i] = nums[i];
            } else if (i == 2) {
                dp[i] = dp[i-2] + nums[i];
            } else {
                dp[i] = Math.max(dp[i-2], dp[i-3]) + nums[i];
            }

            maxVal = Math.max(dp[i], maxVal);
        }

        return maxVal;
    }
}