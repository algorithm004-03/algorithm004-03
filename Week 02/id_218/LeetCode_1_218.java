package leetcode.week2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/two-sum/description/
 *
 * @author eason.feng at 2019/10/22/0022 19:15
 **/
public class LeetCode_1_218 {

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        LeetCode_1_218 leetCode_1_218 = new LeetCode_1_218();
        int[] res = leetCode_1_218.twoSum(nums, target);
        System.out.println(res);
    }

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return new int[]{};
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int b = target - nums[i];
            if (map.containsKey(b)) {
                return new int[]{i, map.get(b)};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public int[] twoSumWith2On(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return new int[]{};
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int b = target - nums[i];
            if (map.containsKey(b) && map.get(b) != i) {
                return new int[]{i, map.get(b)};
            }
        }
        return new int[]{};
    }

}
