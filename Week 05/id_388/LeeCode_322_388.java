package com.company.leetcode.editor.cn;
//给定不同面额的硬币 coins 和一个总金额 amount。
// 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
// 如果没有任何一种硬币组合能组成总金额，返回 -1。
// count = 4
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


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_322 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];

        int sum = 0;
        while (sum <= amount) {
            int min = -1;
            for (int coin:coins) {
                if (sum >= coin && dp[sum - coin] != -1) {
                    int temp = dp[sum - coin] + 1;
                    min = min < 0 ? temp : Math.min(temp,min);
                }
            }
            dp[sum] = min;
            sum++;
        }

        return dp[amount];
    }
//
//    public static void main(String[] args) {
//        Solution s = new Solution();
//        //Wrong Answer: input:[186,419,83,408] 6249 Output:-1 Expected:20
////        int res = s.coinChange(new int[]{186,419,83,408},6249);
//        int res = s.coinChange(new int[]{1,2,5},11);
//        System.out.println(res);
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
