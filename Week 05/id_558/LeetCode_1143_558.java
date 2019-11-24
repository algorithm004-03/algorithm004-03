package Week04;

import java.util.Arrays;

/**
 * @see <a href="1143">https://leetcode-cn.com/problems/longest-common-subsequence/submissions/</a>
 * 最长公共子序列
 */
public class LeetCode_1143_558 {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();
        int[][] dp = new int[s1.length + 1][s2.length + 1];
        for (int i = 1; i < s1.length + 1; i++) {
            for (int j = 1; j < s2.length + 1; j++) {
                if (s1[i - 1] == s2[j - 1]) { //如果末端相同
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else { //如果末端不同
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[s1.length][s2.length];
    }
}
