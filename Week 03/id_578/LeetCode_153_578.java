package com.hand.week3;

/**
 * @description:
 * @version: 1.0
 * @author: xiantao.han@hand-china.com
 * @Date: 2019/11/2
 */
public class LeetCode_153_578 {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        if (nums[high] >= nums[0]) return nums[0];
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid + 1] < nums[mid]) return nums[mid + 1];
            if (nums[mid] < nums[mid - 1]) return nums[mid];
            if (nums[mid] > nums[0]) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}
