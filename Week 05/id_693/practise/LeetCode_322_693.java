package id_693.practise;

import org.junit.Assert;

import java.util.Arrays;

/**
 * @Desc 322. 零钱兑换	https://leetcode-cn.com/problems/coin-change/description/
 * @Auther 李雷(KyLin)
 * @Date 2019/11/14
 */
public class LeetCode_322_693 {
    // dp 解法：dp[i] = min(dp[i],dp[i - coin] + 1);
    public int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    //记忆化搜索
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        return bfs(coins, amount, dp);

    }

    private int bfs(int[] coins, int amount, int[] dp) {
        if (amount == 0) {
            return 0;
        }
        if (dp[amount] != 0) {
            return dp[amount];
        }
        int ans = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (amount - coin < 0) {
                continue;
            }
            int a = bfs(coins, amount - coin, dp);
            if (a == -1) {
                continue;
            }
            ans = Math.min(ans, a + 1);
        }
        return dp[amount] = ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {
        Assert.assertEquals(3, new LeetCode_322_693().coinChange(new int[]{1, 2, 5}, 11));
        Assert.assertEquals(-1, new LeetCode_322_693().coinChange(new int[]{2}, 3));
    }
}
