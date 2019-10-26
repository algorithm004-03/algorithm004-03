import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 *
 * https://leetcode-cn.com/problems/two-sum/description/
 *
 * algorithms
 * Easy (45.73%)
 * Total Accepted:    332.4K
 * Total Submissions: 727K
 * Testcase Example:  '[2,7,11,15]\n9'
 *
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
 * 
 */
class Solution {
    // 暴力解法双重for循环
    // public int[] twoSum(int[] nums, int target) {
    //    for(int i = 0; i < nums.length; i++) {
    //        for(int j = i + 1; j < nums.length; j++) {
    //            if(nums[i] == target - nums[j]) {
    //                return new int[] {i, j};
    //            }
    //        }
    //    }
    //    return new int[2];
    // }
    
    // 空间换时间 用hash表存 
    // 可以一边遍历一边存
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[] { map.get(temp), i };
            }
            map.put(nums[i], i);
        }
        return new int[2];
    }
}
