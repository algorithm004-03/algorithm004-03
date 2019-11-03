package com.ning.test;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述：
 *
 * @author shaoyu
 * @create 2019-09-25 下午7:49
 */
public class LeetCode_1_148 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    @Test
    public void test() {
        int[] nums = {2,3,4,5,9,10,17};
        int[] arr = twoSum(nums, 19);

        for(int n : arr) {
            System.out.println(n);
        }
    }
}
