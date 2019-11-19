/*
Dp 算法解决

先找小于等于n 的 完全平方数k*k
dp[i] 表示凑成和为i需要的最少的数字个数
dp[i] = min(dp[i-1*1], dp[i-2*2], dp[i-3*3] ..... dp[i-k*k]) + 1;
特殊的，有 dp[0] = 0;
 */

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int k = 1; k*k <= i; k++) {
                dp[i] = Math.min(dp[i], dp[i-k*k] + 1);
            }
        }

        return dp[n];
    }
}