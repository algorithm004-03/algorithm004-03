package practice;

import java.util.*;

public class LeetCode_15_368 {

    /* 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
    找出所有满足条件且不重复的三元组。
    注意：答案中不可以包含重复的三元组。
    链接：https://leetcode-cn.com/problems/3sum */

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = threeSum(nums);
        res.stream().forEach(list -> {
            list.stream().forEach(integer -> {
                System.out.print(integer + " ");
            });
            System.out.println();
        });
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (((j > i + 1) && nums[j] == nums[j-1]) || sum < 0) {
                    j++;
                } else if (((k < nums.length - 1) && nums[k] == nums[k+1]) || sum > 0) {
                    k--;
                } else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                }
            }
        }
        return res;
    }
}
