package com.hand.week1.class3;

/**
 * @description:LeetCode26. 删除排序数组中的重复项
 * @version: 1.0
 * @author: xiantao.han@hand-china.com
 * @Date: 2019/10/16
 */
public class LeetCode26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; ++j) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
