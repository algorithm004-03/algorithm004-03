package com.github.kylefeng;

/**
 * 153. 寻找旋转排序数组中的最小值
 *
 * @author kylefeng
 * @time 2019/11/3 22:03
 */
public class LeetCode_153_038 {

    public static int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }
        return nums[left];
    }

}
