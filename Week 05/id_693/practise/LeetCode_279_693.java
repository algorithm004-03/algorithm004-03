package id_693.practise;

import java.util.Arrays;

/**
 * @Desc 279. 完全平方数	https://leetcode-cn.com/problems/perfect-squares/
 * @Auther 李雷(KyLin)
 * @Date 2019/11/15
 */
public class LeetCode_279_693 {
    //dp方程，和零钱问题类似
    /*
    1、子问题：f[i] = min(f[i],f[i - j*j] + 1)
    2、状态数组：dp[i]
    3、dp方程：dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= n; j++) {
                if (j * j <= i) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
            }
        }
        return dp[n];
    }

    //对上面进行优化
    public int numSquares2(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}