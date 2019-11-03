import java.util.Arrays;
/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 * 双循环+哈希 5ms
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(new Integer(nums[i]), i);

        }
        for (int j = 0; j < nums.length; j++) {
            if (map.containsKey(new Integer(target - nums[j])) && (j != map.get(new Integer(target - nums[j])))) {
                return new int[]{j, map.get(new Integer(target - nums[j]))};
            }
        }
        return null;
    }
}
// @lc code=end

// 单循环 3ms
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int j = 0; j < nums.length; j++) {
            if (map.containsKey(new Integer(target - nums[j])) && (j != map.get(new Integer(target - nums[j])))) {
                return new int[]{j, map.get(new Integer(target - nums[j]))};
            }
            map.put(new Integer(nums[j]), j);
        }
        return null;
    }
}
