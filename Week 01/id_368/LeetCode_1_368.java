import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode_1_368 {

    /* 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
    https://leetcode-cn.com/problems/two-sum/ */

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        Arrays.stream(twoSum(nums, target)).forEach(num -> {
            System.out.println(num);
        });
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (map.containsKey(num)) {
                return new int[]{map.get(num), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
