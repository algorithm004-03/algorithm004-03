package com.test.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SolutionTwoNum1 {


    @Test
    public void test1() {
        System.out.println(Arrays.toString(twoSum_20191017_1(new int[]{3,3,4,7}, 10)));
        System.out.println(Arrays.toString(twoSum_20191017_2(new int[]{3,3,4,7}, 10)));
        System.out.println(Arrays.toString(twoSum_20191017_3_best(new int[]{3,3,4,7}, 10)));
    }


    /**
     * 1.暴力方法：两层for循环
     * 2.两遍map
     * 3.一遍map
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum_20191017_1(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i ++) {
            for (int j = i + 1; j < nums.length; j ++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }

    public int[] twoSum_20191017_2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i ++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
        }
        return new int[2];
    }

    public int[] twoSum_20191017_3_best(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            int result = target - nums[i];
            if (map.containsKey(result)) {
                return new int[]{i, map.get(result)};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[2];
    }

}
