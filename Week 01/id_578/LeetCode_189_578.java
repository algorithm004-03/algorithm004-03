package com.hand.week1.class3;

/**
 * @description:LeetCode189. 旋转数组
 * @version: 1.0
 * @author: xiantao.han@hand-china.com
 * @Date: 2019/10/16
 */
public class LeetCode189 {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
