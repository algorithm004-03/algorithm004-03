/*
 * @lc app=leetcode.cn id=322 lang=csharp
 *
 * [322] 零钱兑换
 */

// @lc code=start
using System;

public class Solution {
    public int CoinChange(int[] coins, int amount) {
        int max = amount+1;
        int[] dp = new int[amount + 1];  
        Array.Fill(dp, max);  
        dp[0] = 0;   
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.Length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.Min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
// @lc code=end

