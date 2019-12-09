package com.hand.week2;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @version: 1.0
 * @author: xiantao.han@hand-china.com
 * @Date: 2019/10/27
 */
public class LeetCode_1_578 {
    public int[] twoSum(int[] nums, int target) {
        //key nums[i] value i
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            //target=nums[i]+tmp
            int tmp = target - nums[i];
            if (map.containsKey(tmp)) {
                return new int[]{map.get(tmp), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}
