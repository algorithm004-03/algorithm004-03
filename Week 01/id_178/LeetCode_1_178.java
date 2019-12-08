package org.geektime.weak01;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * Created by fukan on 2019/10/22.
 */
public class LeetCode_1_178 {
    public static void main(String[] args) {
        int[]nums = {2, 7, 11, 15};
        LeetCode_1_178 instance = new LeetCode_1_178();
        instance.twoSum5(nums,9);
    }

    /**
     * 暴力破解法
     */
    public int[] twoSum1(int[] nums, int target) {
        int[] result = {};
        for (int i = 0 ; i < nums.length ; i++){
            for (int j = 0 ; j< nums.length;j++){
                if(i != j){
                    if( nums[i] + nums[j] == target){
                        result = new int[]{i,j};
                    }
                }
            }
        }
        return result;
    }

    /**
     * 官方暴力破解法
     */
    public int[] twoSum2(int[] nums, int target) {
        for (int i = 0;i < nums.length;i++){
            for (int j = i+1 ;j < nums.length;j++){
                if (nums[j] == target - nums[i]){
                    return new int[]{i,j};
                }
            }
        }

        throw new IllegalArgumentException("No Two Sum Solution");
    }

    /**
     * 两遍哈希表
     */
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length;i++){
            map.put(nums[i],i);
        }
        for (int i = 0;i < nums.length ;i++){
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i ){
                return new int[]{i,map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No Two sum solution");
    }

    /**
     * 一遍哈希表
     */
    public int[] twoSum4(int[] nums, int target) {
       Map<Integer,Integer>  map = new HashMap<>();
       for (int i = 0;i < nums.length; i++){
           int complement = target - nums[i];
           if (map.containsKey(complement)){
               return new int[]{map.get(complement),i};
           }
           map.put(nums[i],i);
       }
       throw new IllegalArgumentException("There No Two Sum Solution");
    }

    /**
     *
     */
    public int[] twoSum5(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0;i < nums.length; map.put(nums[i], ++i)){
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target-nums[i])-1,i};
            }
        }
        throw new IllegalArgumentException("No Solution");
    }
}
