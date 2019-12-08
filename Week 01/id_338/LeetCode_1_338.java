/**
 * User: liwei
 * Date: 2019/10/19  19:46
 * Desc:
 */
public class LeetCode_1_338 {
    class Solution {
        // 将 a + b = target 问题转化为 b =  target - a
        // 一次遍历即可解决， O(N)
        // 注意： new int[]{} 赋值的时候不能指定大小。map.containsKey
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    return new int[]{map.get(nums[i]), i};
                } else {
                    map.put(target - nums[i], i);  // b = target - a
                }
            }
            return new int[]{0, 0};
        }
    }
}
