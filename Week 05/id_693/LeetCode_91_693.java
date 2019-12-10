package id_693;

import org.junit.Assert;

/**
 * @Desc 91. 解码方法	https://leetcode-cn.com/problems/decode-ways/
 * @Auther 李雷(KyLin)
 * @Date 2019/11/16
 */
public class LeetCode_91_693 {
    //dp
    /*
        1、分解子问题：
        2、定义状态数组：
        3、DP方程：
     */
    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[len] = 1;
        dp[len - 1] = s.charAt(len - 1) == '0' ? 0 : 1;
        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) != '0') {
                if ((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0') <= 26) {
                    dp[i] = dp[i + 1] + dp[i + 2];
                } else {
                    dp[i] = dp[i + 1];
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Assert.assertEquals(1,new LeetCode_91_693().numDecodings("27"));
    }
}
