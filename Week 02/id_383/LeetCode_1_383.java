import java.util.HashMap;
import java.util.Map;

public class LeetCode_1_383 {

    public int[] twoSum1(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0, j = len - 1; i < j; i++) {
            for (int k = i + 1; k < len; k++) {
                if ((nums[i] + nums[k]) == target) {
                    return new int[] {i, k};
                }
            }
        }
        return new int[] {};
    }

    public int[] twoSum2(int[] nums, int target) {
        Map map = new HashMap<>();
        for (int i = 0, len = nums.length; i < len; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0,len = nums.length - 1; i < len; i++) {
            int num = target - nums[i];
            if (map.containsKey(num)) {
                int index = (int)map.get(num);
                if (i != index) {
                    return new int[] {i, index};
                }
            }
        }
        return new int[] {};
    }

}