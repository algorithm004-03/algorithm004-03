package com.company.leetcode.editor.cn;//给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
//
// 示例 1:
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
//
//
// 示例 2:
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
// Related Topics 数组 动态规划



//leetcode submit region begin(Prohibit modification and deletion)
class Solution_152 {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int imax = res;
        int imin = res;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }

            imax = Math.max(imax * nums[i],nums[i]);
            imin = Math.min(imin * nums[i],nums[i]);

            res = Math.max(imax,res);
        }

        return res;
    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        int[] nums = new int[]{2,3,-2,4};
//        int res = s.maxProduct(nums);
//        System.out.println(res);
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
