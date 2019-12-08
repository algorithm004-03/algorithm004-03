/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 * 思路1,每次转一位，转K次。
 * 思路2,每次换K位，空间K交换。
 * 思路3,循环处理。
 * 思路4，双指针，与临时变量
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        if (nums.length >0){
            k = k % nums.length;
            int[] temp = new int[k];
            System.arraycopy(nums, nums.length - k, temp, 0, k);
            System.arraycopy(nums, 0, nums, k, nums.length - k);
            System.arraycopy(temp, 0, nums, 0, temp.length);
        }
    }
}
// @lc code=end