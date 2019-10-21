package com.jane.part1;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution {
    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15};
        int target = 26;

        int[] result = twoSum(a, target);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    /*
    public static int[] twoSum(int[] nums, int target) {
        int[] a = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    a[0] = i;
                    a[1] = j;
                    break;
                }
            }
        }

        return a;
    }*/

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int data = target - nums[i];
            if (map.containsKey(data)){
                return new int[] {map.get(data),i};
            }

            map.put(nums[i],i);
        }

        return null;
    }
}
