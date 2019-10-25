package com.hand.week1.class3;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:LeetCode1. 两数之和
 * @version: 1.0
 * @author: xiantao.han@hand-china.com
 * @Date: 2019/10/16
 */
public class LeetCode1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            //target=nums[i]+difference
            int difference = target - nums[i];
            if (map.containsKey(difference)) {
                return new int[]{i, map.get(difference)};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
