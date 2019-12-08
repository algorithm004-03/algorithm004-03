package id_693.practise;

import org.junit.Assert;

/**
 * @Desc 1143. 最长公共子序列	https://leetcode-cn.com/problems/longest-common-subsequence/
 * @Auther 李雷(KyLin)
 * @Date 2019/11/11
 */
public class LeetCode_1143_693 {

    //dp 解法：默认设置行列为0，如果遇到相同的，则直接 用斜边+1，否则直接取上下位置的最大值。
    /*
        dp方程： 相同  dp[i][j] = dp[i - 1][j - 1] + 1;
                不同  dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
     */
    public int longestCommonSubsequence2(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    //此处的i - 1  j - 1 是为了获取2个字符串同时减少1 的情况下最长公共子序列的数量。
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }

    //对解法1 空间优化 二维数组优化为2个一维数组，.....可以继续优化看成一维数组，因为他只需要左上角的，如果缓存起来那不就好了。。。。
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[] dp = new int[n + 1];
        int[] tempdp = new int[n + 1];//只是用户获取原左上角的值
        for (int i = 1; i <= m; i++) {
            int temp = 0;
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[j] = tempdp[j - 1] + 1;
                } else {
                    dp[j] = Math.max(temp, tempdp[j]);
                }
                temp = dp[j];
            }
            tempdp = dp.clone();
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Assert.assertEquals(3, new LeetCode_1143_693().longestCommonSubsequence("abcde", "ace"));
        Assert.assertEquals(3, new LeetCode_1143_693().longestCommonSubsequence("abcde", "ace"));
        Assert.assertEquals(2, new LeetCode_1143_693().longestCommonSubsequence("oxcpqrsvwf", "shmtulqrypy"));
        Assert.assertEquals(2, new LeetCode_1143_693().longestCommonSubsequence("pmjghex", "hafcdeb"));
        Assert.assertEquals(1, new LeetCode_1143_693().longestCommonSubsequence("ac", "hcc"));
        Assert.assertEquals(4, new LeetCode_1143_693().longestCommonSubsequence("pmjghexybyrgzczy", "hafcdqbgncrcbihkd"));
    }
}