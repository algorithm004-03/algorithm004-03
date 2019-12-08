package com.company.leetcode.editor.cn;
//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
// 这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。
// 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，
// 系统会自动报警。
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，
// 能够偷窃到的最高金额。
//
// 示例 1:
//
// 输入: [2,3,2]
//输出: 3
//解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
//
//
// 示例 2:
//
// 输入: [1,2,3,1]
//输出: 4
//解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。
// Related Topics 动态规划


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_213 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        //copy
        int[] arr1 = Arrays.copyOfRange(nums,1,nums.length);
        int[] arr2 = Arrays.copyOfRange(nums,0,nums.length - 1);

        return Math.max(helper(arr1),helper(arr2));
    }

    private int helper(int[] nums) {
        int[][] dp  = new int[nums.length][2];
        dp[0][1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1]); //不偷
            dp[i][1] = dp[i - 1][0] + nums[i]; //偷
        }
        return Math.max(dp[nums.length - 1][0],dp[nums.length - 1][1]);
    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        int[] nums = new int[]{2,3,2};
//        System.out.println(s.rob(nums));
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
