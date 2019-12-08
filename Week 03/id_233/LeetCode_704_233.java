package com.luxuedong.BinarySearchPractice;

/**
 * describe:
 * creator: luxuedong
 * date: 2019/11/3 14:12
 */
public class LeetCode_704_search {
    public int search(int[] nums, int target) {
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
        return -min - 1;
    }
}
