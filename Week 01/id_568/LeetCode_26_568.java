package com.leetcode.kelvin;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author kelvin
 * @date 2019/10/16 3:10 PM
 */
public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slowIndex = 0;
        //相同的索引直接跳过
        for (int quickIndex = 1; quickIndex < nums.length; quickIndex++) {
            //不同的索引位置,慢指针增加,两个指针重合复制
            if (nums[quickIndex] != nums[slowIndex]) {
                slowIndex++;
                nums[slowIndex] = nums[quickIndex];
            }
        }
        return slowIndex + 1;
    }




    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        removeDuplicates(nums);
        printArray(nums);
    }

    private static void printArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
