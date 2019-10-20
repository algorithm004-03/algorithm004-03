package com.github.kylefeng.week01;

/**
 * 26. 删除排序数组中的重复项
 *
 * @author kylefeng
 * @time 2019/10/19 09:20
 */
public class LeetCode_26_038 {

    public static int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }

        if (nums.length <= 1) {
            return nums.length;
        }

        int i = 0;
        int j = 1;

        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                nums[i + 1] = nums[j];
                ++i;
            } else {
                ++j;
            }
        }
        return i + 1;
    }

}
