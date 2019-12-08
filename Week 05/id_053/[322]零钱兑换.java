//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。 
//
// 示例 1: 
//
// 输入: coins = [1, 2, 5], amount = 11
//输出: 3 
//解释: 11 = 5 + 5 + 1 
//
// 示例 2: 
//
// 输入: coins = [2], amount = 3
//输出: -1 
//
// 说明: 
//你可以认为每种硬币的数量是无限的。 
// Related Topics 动态规划


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return -1;
        if(coins.length == 1 && (amount % coins[0] != 0)) return -1;
        //f(n) = min(f(n - k)  ) + 1;
        //k值是变量，从coins里面取
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,amount + 1);
        dp[0] = 0;
        for (int i = 1;i <= amount;i++) {
            for (int j = 0;j < coins.length;j++){
                if(i >= coins[j]){
                    dp[i] = Math.min(dp[i-coins[j]] + 1,dp[i]);
                }
            }
        }
        return dp[dp.length - 1] == amount + 1 ? -1 : dp[dp.length - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
