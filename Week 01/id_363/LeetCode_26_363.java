package com.test.leetcode;

import org.junit.Test;

import java.util.List;


public class SolutionRemoveDuplicate26 {


    @Test
    public void test1() {
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }


    /**
     * 删除数组中的重复元素，返回新数组的长度
     * 1.索引：记录不是重复数组的索引位置
     * @param nums
     * @return
     */
    public int removeDuplicates_best(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int lastNonDuplicateIndex = 1;
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] != nums[i - 1] && i > lastNonDuplicateIndex) {
                nums[lastNonDuplicateIndex ++] = nums[i];
            }
        }
        return lastNonDuplicateIndex ;
    }


    /**
     * 2. 前面有多少重复的值移动多少位
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int duplicateCount = 0;
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] == nums[i - 1]) {
                duplicateCount ++;
            } else {
                if (duplicateCount != 0) {
                    nums[i - duplicateCount] = nums[i];
                }
            }
        }
        return nums.length - duplicateCount ;
    }


    /**
     * 双指针 和 1.索引：记录不是重复数组的索引位置 思路一致
     * @param nums
     * @return
     */
    public int removeDuplicates3(int[] nums) {
        if (nums == null) return 0;
        int i = 0, j = i + 1;
        while (j < nums.length) {
            if (nums[j] != nums[i] && j - i > 1) {
                nums[++ i] = nums[j];
            }
            j ++;
        }
        return i + 1;
    }

}
