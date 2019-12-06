package id_693;

/**
 * @Author 李雷（KyLin）
 * @Desc 44. 通配符匹配	https://leetcode-cn.com/problems/wildcard-matching/
 * @Date 2019/12/06
 */
public class LeetCode_44_693 {
    /**
     * 动态规划     相同或者是?：dp[i][j] = dp[i - 1][j - 1];
     * 是*        ：dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
     */
    class Solution {
        public boolean isMatch(String s,String p) {
            int m = s.length();
            int n = p.length();
            boolean[][] dp = new boolean[m + 1][n + 1];
            dp[0][0] = true;//防止""
            for (int i = 1; i <= n; i++) {
                if (p.charAt(i - 1) != '*') break;
                dp[0][i] = true;//对前面的* 都设置为true
            }
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (p.charAt(j - 1) == '*') {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                    }
                }
            }
            return dp[m][n];
        }
    }
}
