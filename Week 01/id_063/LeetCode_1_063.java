import java.util.HashMap;
import java.util.Map;


/*
从左到右迭代数组中元素，每一个元素迭代时候判断已经迭代的元素中有没有匹配的
判断是否匹配需要额外的哈希结构缓存已经迭代过的元素的数值和下标

向Hash中插入数值或者是触发了Rehash会带来一定开销，严格讲时间复杂度比O(n)高
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
         Map<Integer, Integer> val2idx = new HashMap<>(nums.length + 1, 1);

         val2idx.put(nums[0], 0);

         for (int i = 1; i < nums.length; i++) {
            if (val2idx.containsKey(target - nums[i])) {
                return new int[] { val2idx.get(target - nums[i]), i };
            }

            val2idx.put(nums[i], i);
         }

         return new int[] {0, 0};
    }
}