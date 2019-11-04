package com.luxuedong.BinarySearchPractice;

/**
 * describe:
 * creator: luxuedong
 * date: 2019/11/3 14:10
 */
public class LeetCode_35_searchInsert {
    public int searchInsert(int[] nums, int target) {
        int max, min, mid;
        min = 0;
        max = nums.length - 1;

        while (min <= max) {
            mid = (max + min) >> 1;
            if (target > nums[mid])
                min = mid + 1;
            else if (target < nums[mid])
                max = mid - 1;
            else
                return mid;
        }
        return min;
    }
}
