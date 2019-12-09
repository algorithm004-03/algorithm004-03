
/*

思路
动态规划求解
dp[i][j]表示从i, j位置走到右下角的方法数
显然有
dp[i][j] = sum ( dp[i, j+1], dp[i+1, j] )

 */


class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];

        // i = m-1时候先初始化种子
        for (int j = n - 1; j >= 0; j--) {
            dp[j] = 1;      // 最底下一层肯定都只有一种走法
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[j] = dp[j] + dp[j+1];
            }
        }

        return dp[0];
    }
}
