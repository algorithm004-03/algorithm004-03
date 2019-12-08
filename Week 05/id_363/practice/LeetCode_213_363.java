package com.test.leetcode.week05;

import org.junit.Test;


public class SolutionHouseRobii213 {


    @Test
    public void test1() {
        System.out.println(rob(new int[]{2,3,2}));
        System.out.println(rob(new int[]{1,2,3,1}));
    }


    /**
     * 所有的房屋都围成一圈，意味着如果选择第一个，那么不能选择最后一个
     *
     * 子问题: max(rob(0, len -2), rob(1, len - 1));
     * 状态数组 : 记录到当前状态偷和不偷的最大金额
     * dp方程 : 0 表示偷 1 表示不偷
     * dp[i][0] = dp[i-1][1] + nums[i] dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1])
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length - 1));
    }

    // dp 中存储当前元素必须偷的最大值
    // dp[i] = Math.max(dp[i - 2] + nums[i] , dp[i - 1]);
    private int helper(int[] nums, int start, int end) {
        int pre = 0, cur = 0, temp = 0;
        for (int i = start; i <= end; i ++) {
            temp = cur;
            cur = Math.max(pre + nums[i], cur);
            pre = temp;
        }
        return cur;
    }

    // [start,end] 使用include 和 exclude 命名会更好点
    private int helper2(int[] nums, int start, int end) {
        int preInclude = nums[start], preExclude = 0;
        for (int i = start + 1; i <= end; i ++) {
            int include = preExclude + nums[i];
            int exclude = Math.max(preInclude, preExclude);
            preInclude = include;
            preExclude = exclude;
        }
        return Math.max(preInclude, preExclude);
    }


}
