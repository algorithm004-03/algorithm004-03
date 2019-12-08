/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        // 双指针 往前移动非零元素 
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // 出现了元素为0的情况
                if (i > p) {
                    nums[p] = nums[i];
                    nums[i] = 0;
                }
                p++;
            }
        }
    }
}
