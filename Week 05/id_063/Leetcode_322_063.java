/*
思路

动态规划

dp[i] 表示i块钱最少的硬币数
最后一个硬币只可能是coin中n中硬币面值其中一种
dp[i] = min ( dp[i-coin[0]], dp[i-coin[1]] ...... dp[i- coin[len-1]] ) + 1

 */

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        for (int i = 0; i <= amount; i++) {
            if (i == 0) {
                dp[i] = 0;
                continue;
            }

            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    if (dp[i - coins[j]] != -1) {
                        min = Math.min(dp[i - coins[j]], min);
                    }
                }
            }

            dp[i] = (min == Integer.MAX_VALUE) ? -1 : min + 1;
        }

        return dp[amount];
    }
}