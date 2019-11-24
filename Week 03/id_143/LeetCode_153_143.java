/*
 * @lc app=leetcode.cn id=153 lang=java
 *
 * [153] 寻找旋转排序数组中的最小值
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }

        int left = 0;
        int right = nums.length - 1;
        int midIndex ;


        while(left < right){
            midIndex = left + (right - left)/2;

            if(nums[left] > nums[left + 1]){
                return nums[left +1];
            }else if(nums[left] < nums[midIndex] ){ //前段有序，去后半段找
                left = midIndex ;
            }else if(nums[right] > nums[midIndex] && nums[midIndex] <= nums[left]){
                right = midIndex ;
            }

        }
        return nums[0];

    }
}
// @lc code=end

