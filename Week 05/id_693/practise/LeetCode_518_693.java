package id_693.practise;

/**
 * @Desc 518. 零钱兑换 II	https://leetcode-cn.com/problems/coin-change-2/
 * @Auther 李雷(KyLin)
 * @Date 2019/11/15
 */
public class LeetCode_518_693 {
    //dp    标准背包问题。
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
