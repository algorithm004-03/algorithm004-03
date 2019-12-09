package id_713;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * LeetCode 题号: 1
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum {
    /*
    思路:
    1. 使用HashMap作为缓存, 并记录数字的索引值
    2. 遍历数组, 当 target 减去 当前值, 出现在缓存中时, 就是满足了 这2个数之和等于target
    3. 返回缓存中记录的索引值即可
     */
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>(); // 定义map, key为数值, value为索引值

        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (map.containsKey(tmp)) { // target - 当前值, 出现在map中, 即找到了这2个元素
                res[0] = map.get(tmp); // 获取对应数值的索引值
                res[1] = i;
                return res;
            }
            map.put(nums[i], i); // 无需else, 因为上面if进入的话, 会return, 且遍历任何一个元素时, 都要加入到缓存map中
        }

        return res;
    }
}