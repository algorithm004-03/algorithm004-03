/*
 * @lc app=leetcode.cn id=115 lang=java
 *
 * [115] 不同的子序列
 */
/*
动态规划解决
dp(i, j) 表示s[0:i] 中选出的子序列，包含t[0:j] 的个数
若s[i] != t[j]
    dp(i, j) = dp(i-1, j)
s[i] == t[j]
    dp(i, j) = dp(i-1, j-1) + dp(i-1, j)
 */

// @lc code=start
class Solution {
    public int numDistinct(String s, String t) {
        if (s.length() == 0) {
            return t.length() == 0 ? 1 : 0;
        }

        if (t.length() == 0) {
            return 0;
        }
        int sN = s.length();
        int tN = t.length();
        int[][] dp = new int[sN][tN];

        dp[0][0] = s.charAt(0) == t.charAt(0) ? 1 : 0;
        for (int i = 1; i < sN; i++) {
            dp[i][0] = s.charAt(i) == t.charAt(0) ? dp[i-1][0] + 1 : dp[i-1][0];

            for (int j = 1; j <= i && j < tN; j++) {
                if (t.charAt(j) != s.charAt(i)) {
                    dp[i][j] = j <= i-1 ? dp[i-1][j] : 0;
                } else {
                    dp[i][j] += (j-1 <= i-1 && j-1 >= 0) ? dp[i-1][j-1] : 0;
                    dp[i][j] += (j <= i-1) ? dp[i-1][j] : 0;
                }
            }
        }

        return dp[sN-1][tN-1];
    }

}
// @lc code=end

