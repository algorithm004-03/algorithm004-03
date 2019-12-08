package com.test.leetcode.week03;

import org.junit.Test;

import java.util.Arrays;


public class SolutionCoinChange322 {


    @Test
    public void test1() {
        System.out.println(coinChange(new int[]{2}, 3));
        System.out.println(coinChange(new int[]{1,2,5}, 11));
        System.out.println(coinChange2(new int[]{2}, 3));
        System.out.println(coinChange2(new int[]{1,2,5}, 11));
        System.out.println(coinChange3(new int[]{2}, 3));
        System.out.println(coinChange3(new int[]{1,2,5}, 11));

        System.out.println("-----------------------");
        System.out.println(coinChange_20191115_1(new int[]{2}, 3));
        System.out.println(coinChange_20191115_1(new int[]{1,2,5}, 11));
        System.out.println(coinChange_20191115_2(new int[]{2}, 3));
        System.out.println(coinChange_20191115_2(new int[]{1,2,5}, 11));
        System.out.println(coinChange_20191115_3(new int[]{2}, 3));
        System.out.println(coinChange_20191115_3(new int[]{1,2,5}, 11));
    }




    /**
     * 动态规划讨论：递归(暴力)-递归+记忆表(自顶想下)-循环(自下向上)
     * 给定不同面额的coins 和 一个总金额amount，求凑成总金额所需要的最少的硬币个数
     *  1.暴力方法：f(amount) = 1 + min(f(amount - coin1), f(amount - coin2), f(amount - coin3))
     *
     *  1.子问题  求解 amount-coint1 所需要的最少硬币树
     *  2.状态数组 dp[amount]=amount需要的最少的硬币个数
     *  3.dp方程 dp[i] = min(dp[i], dp[i - coin])
     *
     *  时间复杂度分析：
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange_20191115_1(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        return helper_20191115_1(coins, amount);
    }


    /**
     * 如果存在可以最少硬币个数，返回硬币个数
     * 如果不存在硬币个数，返回 -1
     * @param coins
     * @param amount
     * @return
     */
    private int helper_20191115_1(int[] coins, int amount) {
        // termination
        if (amount == 0) {
            return 0;
        }
        // process
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (amount < coin) {
                continue;
            }
            int subRes = helper_20191115_1(coins, amount - coin);
            if (subRes == -1) { // 子问题无解
                continue;
            }
            res = Math.min(res, subRes);
        }
        // drill down
        // reverse
        return res == Integer.MAX_VALUE ? -1 : res + 1;
    }

    /**
     * 时间复杂度是O(nk)
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange_20191115_2(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -2);
        return helper_20191115_2(coins, memo, amount);
    }

    private int helper_20191115_2(int[] coins, int[] memo, int amount) {
        // termination
        if (amount == 0) {
            return 0;
        }
        if (memo[amount] > -2) {
            return memo[amount];
        }
        // process
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (amount - coin < 0) {
                continue;
            }
            int subRes = helper_20191115_2(coins, memo, amount - coin);
            if (subRes == -1) {
                continue;
            }
            res = Math.min(res, subRes);
        }
        // drill down
        // reverse
        if (res == Integer.MAX_VALUE) {
            memo[amount] = -1;
        } else {
            memo[amount] = res + 1;
        }
        return memo[amount];
    }

    /**
     * 时间复杂度是O(nk)
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange_20191115_3(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i ++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }


    /**
     * 给定不同面额的硬币coins 和 一个总金额amount.求凑成总金额所需要的最少的硬币个数
     * 如果没有任何一种硬币组合能组成总金额，返回-1
     *
     * 子问题：[1,2,5] amount = 11  11 所需要的最少硬币数 = 1 + min ( 11 - 1, 11- 2, 11 - 5);
     * 状态数组：dp[] 存储每个金额所需要的最少的硬币个数
     * dp方程：dp[i] = 1+ min(dp[i - coin1], dp[i - coin2], dp[i - coin3])
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (coins == null ) {
            return -1;
        }
        return helper(coins, amount);
    }

    private int helper(int[] coins, int amount) {
        // termination
        if (amount == 0) {
            return 0;
        }
        // process
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (amount - coin < 0) {
                continue;
            }
            int subRes = helper(coins, amount - coin);
            if (subRes == -1) {
                continue;
            }
            res = Math.min(res, subRes);
        }
        // drill down
        return res == Integer.MAX_VALUE ? -1 : res + 1;
        // reverse
    }



    public int coinChange2(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        for (int m : memo) {
            memo[m] = -2;
        }
        return helper2(coins, memo, amount);

    }

    private int helper2(int[] coins,int[] memo, int amount) {
        // termination
        if (amount == 0) {
            return 0;
        }
        if (memo[amount] > 0) {
            return memo[amount];
        }
        // process
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (amount - coin < 0) {
                continue;
            }
            int subRes = helper2(coins, memo, amount - coin);
            if (subRes == -1) {
                continue;
            }
            res = Math.min(res, subRes);
        }
        // drill down
        // reverse
        memo[amount] = res == Integer.MAX_VALUE ? -1 : res + 1;
        return memo[amount];
    }


    public int coinChange3(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i < dp.length; i ++){
            dp[i] = amount + 1;
        }
        for (int i = 1; i <= amount; i ++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
