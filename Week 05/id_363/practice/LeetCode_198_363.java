package com.test.leetcode.week05;

import org.junit.Test;


public class SolutionHouseRob198 {


    @Test
    public void test1() {
        System.out.println(rob(new int[]{1,2,3,1}));
        System.out.println(rob(new int[]{2,7,9,3,1}));

        System.out.println(rob2(new int[]{1,2,3,1}));
        System.out.println(rob2(new int[]{2,7,9,3,1}));

        System.out.println(rob3(new int[]{1,2,3,1}));
        System.out.println(rob3(new int[]{2,7,9,3,1}));
    }


    /**
     * 求和的两个数值不能相邻
     * nums= [1,2,3,1]
     * 当发现当前层的一个值不能计算计算出来下一层的值，那么可能需要一个二维数组
     * 状态 0 表示偷当前层的最大值 1 表示不偷当前层的最大值
     *
     * 1.暴力
     * 2.DP
     * 子问题：数组变小
     * 状态数组：二维状态数组  行表示当前层最大的金额 列表示当前层偷还是不偷
     * dp方程：偷: dp[i][0] = dp[i - 1][1] + nums[i]  dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1]);
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[][] dp = new int[len][2];
        dp[0][0] = nums[0]; dp[0][1]=0;
        for (int i = 1; i < len;i++) {
            dp[i][0] = dp[i-1][1] + nums[i];
            dp[i][1] = Math.max(dp[i - 1][0] , dp[i -1][1]);
        }
        return Math.max(dp[len-1][0], dp[len - 1][1]);
    }

    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int preTou = nums[0], preNotTou = 0;
        for (int i = 1; i < nums.length; i ++) {
            int tou = preNotTou + nums[i];
            int notTou = Math.max(preNotTou, preTou);
            preTou = tou;
            preNotTou = notTou;
        }
        return Math.max(preTou, preNotTou);
    }


    /**
     * dp方程：dp[i] = Math.max(dp[i-1], dp[i -2] + nums[i])
     * 状态数组：数组中存储从0到i一定偷当前层所能得到的最大金额
     * 子问题：数组变小
     * * @param nums
     * @return
     */
    public int rob3(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0; dp[1] = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            dp[i + 1] = Math.max(dp[i], dp[i -1] + nums[i]);
        }
        return dp[nums.length];
    }
}
