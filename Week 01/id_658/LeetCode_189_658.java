/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 */

// @lc code=start
class Solution {
    // 建立一个等长度的数组接收原数组
    public void rotate(int[] nums, int k) {
        // 考虑不够周全
        if (k == 0 || k == nums.length) {
            return;
        }
        int[] tempNums = nums.clone();
        if (k > tempNums.length) {
            k -= tempNums.length;
        }
        for (int i = 0; i < tempNums.length; i++) {
            if (i < k) {
                nums[i] = tempNums[tempNums.length - k + i];
            } else {
                nums[i] = tempNums[i - k];
            }
        }
    }
}
