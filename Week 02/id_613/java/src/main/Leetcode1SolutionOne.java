import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * 将数组的元素都存到hashmap中，然后扫描数组，看看（target - 当前元素）是否在map中
 * 平均时间复杂度O(n)，空间复杂度O(n)
 *
 * 执行用时 : * 3 ms * , 在所有 java 提交中击败了 * 98.87% * 的用户
 * 内存消耗 : * 37 MB * , 在所有 java 提交中击败了 * 92.85% * 的用户
 */
class Leetcode1SolutionOne {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> numsMap = new HashMap<Integer, Integer>();
    int[] result = new int[2];
    for (int i = 0; i < nums.length; i++) {
      if (numsMap.containsKey(target - nums[i])) {
        int otherIdx = numsMap.get(target - nums[i]);
        result[0] = Math.min(i, otherIdx);
        result[1] = Math.max(i, otherIdx);
        return result;
      } else {
        numsMap.put(nums[i], i);
      }
    }

    return result;
  }
}