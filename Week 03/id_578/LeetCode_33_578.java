package com.hand.week3;

/**
 * @description:
 * @version: 1.0
 * @author: xiantao.han@hand-china.com
 * @Date: 2019/11/2
 */
public class LeetCode_33_578 {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (target == nums[mid]) return mid;
            if (nums[mid] >= nums[low]) {
                if (target >= nums[low] && target < nums[mid]) high = mid - 1;
                else low = mid + 1;
            } else {
                if (target > nums[mid] && target <= nums[high]) low = mid + 1;
                else high = mid - 1;
            }
        }
        return -1;
    }
}
