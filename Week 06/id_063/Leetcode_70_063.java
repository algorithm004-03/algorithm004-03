/*
记忆化搜索，递归减枝
dp[i][j] 表示从i位置走到j位置有多少种走法

dp[i][j] = dp[i+1][j] + dp[i+2][j]

 */

class Solution {
    private int[] memo;

    private int solve(int start, int end) {
        if (memo[end - start] != -1) {
            return memo[end - start];
        }

        if (start == end) {
            return 0;
        }

        if (start == end - 1) {
            return 1;
        }

        if (start == end - 2) {
            return 2;
        }

        memo[end - start] = solve(start+1, end) + solve(start+2, end);
        return memo[end - start];
    }

    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }

        memo = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            memo[i] = -1;
        }
        return solve(0, n);
    }
}
