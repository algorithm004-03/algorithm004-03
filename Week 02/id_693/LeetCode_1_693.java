package id_693;

import java.util.HashMap;
import java.util.Map;

/**
 * @Desc 第一周已经做过，不做回顾，只作为作业使用
 * @Auther 李雷(KyLin)
 * @Date 2019/10/21
 */
public class LeetCode_1_693 {
    //再次优化
    public int[] twoSum3(int[] nums,int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length,1);
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[]{map.get(temp),i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }
}
