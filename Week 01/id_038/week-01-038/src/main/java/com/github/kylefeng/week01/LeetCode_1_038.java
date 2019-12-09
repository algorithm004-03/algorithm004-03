package com.github.kylefeng.week01;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 *
 * @author kylefeng
 * @time 2019/10/20 16:39
 */
public class LeetCode_1_038 {

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[]{};
        }

        if (nums.length == 2) {
            return new int[]{0, 1};
        }

        Map<Integer, Integer> hash = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            Integer elem = hash.get(nums[i]);
            if (elem != null) {
                return new int[]{elem, i};
            }
            hash.put(target - nums[i], i);
        }
        return new int[]{};
    }
}
