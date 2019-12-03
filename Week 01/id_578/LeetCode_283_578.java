package com.hand.week1.class3;

/**
 * @description:LeetCode283. 移动零
 * @version: 1.0
 * @author: xiantao.han@hand-china.com
 * @Date: 2019/10/16
 */
public class LeetCode283 {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j++;
            }
        }
    }
}
