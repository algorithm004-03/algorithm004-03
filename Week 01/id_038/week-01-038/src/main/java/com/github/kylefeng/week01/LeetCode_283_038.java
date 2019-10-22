package com.github.kylefeng.week01;

/**
 * 283. 移动零
 *
 * @author kylefeng
 * @time 2019/10/20 16:06
 */
public class LeetCode_283_038 {

    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int zeroIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[zeroIdx] = nums[i];
                if (i != zeroIdx) {
                    nums[i] = 0;
                }
                zeroIdx++;
            }
        }
    }

}
