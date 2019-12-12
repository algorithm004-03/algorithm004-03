package com.company.leetcode.editor.cn;//给定一个无序的整数数组，找到其中最长上升子序列的长度。
//
// 示例:
//
// 输入: [10,9,2,5,3,7,101,18]
//输出: 4
//解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
//
// 说明:
//
//
// 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
// 你算法的时间复杂度应该为 O(n2) 。
//
//
// 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
// Related Topics 二分查找 动态规划



//leetcode submit region begin(Prohibit modification and deletion)
class Solution_300 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        int maxans = 1;
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int maxVal = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxVal = Math.max(maxVal,dp[j]);
                }
            }
            dp[i] = maxVal + 1;
            maxans = Math.max(dp[i],maxans);
        }
        return maxans;
    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        int[] nums = new int[]{10,9,2,5,3,7,101,18};
//        System.out.println(s.lengthOfLIS(nums));
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
