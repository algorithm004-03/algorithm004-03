package id_693;

import java.util.Arrays;

/**
 * @Author 李雷（KyLin）
 * @Desc 115. 不同的子序列	https://leetcode-cn.com/problems/distinct-subsequences/
 * @Date 2019/12/04
 */
public class LeetCode_115_693 {
    /**
     * 动态规划     dp方程：不同：f(i,j) = f(i,j-1) 相同f(i,j) = f(i,j-1) + f(i -1.j-1)
     */
    class Solution {
        public int numDistinct(String s,String t) {
            int sLen = s.length();
            int tLen = t.length();
            int[][] dp = new int[tLen + 1][sLen + 1];
            Arrays.fill(dp[0],1);//考虑""
            for (int i = 1; i <= tLen; i++) {
                for (int j = 1; j <= sLen; j++) {
                    dp[i][j] = dp[i][j - 1];
                    if (s.charAt(j - 1) == t.charAt(i - 1)) {
                        dp[i][j] += dp[i - 1][j - 1];
                    }
                }
            }
            return dp[tLen][sLen];
        }
    }
}
