package id_693;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Desc 1. 两数之和   https://leetcode-cn.com/problems/two-sum/
 * @Auther 李雷(KyLin)
 * @Date 2019/10/16
 */
public class LeetCode_1_693_1 {
    //暴力破解，直接双层循环   时间复杂度   0(n^2)
    public int[] twoSum(int[] nums,int target) {
        for (int i = 0; i < nums.length - 1; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }

    /**
     * 1、开始优化，
     * 首先用        new LeetCode_1_693().twoSum(new int[]{2,7,11,15,16,17,18,19,20,21,22,23,24},91);
     * 获得次数最高 为78，数据越多次数越多。
     * 升维，空间换时间
     * 用hash表
     * 结果：0(n)
     */

    //使用hash 2个 for    0(n)
    public int[] twoSum2(int[] nums,int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length,1);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i,map.get(complement)};
            }
        }
        return new int[0];
    }

    //再次优化
    public int[] twoSum3(int[] nums,int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length,1);
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                //因为后面才会知道结果，那么返回下标就需要反向
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LeetCode_1_693_1().twoSum3(new int[]{3,2,4},6)));
        ;
        System.out.println(Arrays.toString(new LeetCode_1_693_1().twoSum(new int[]{2,7,11,15,16,17,18,19,20,21,22,23,24},91)));
        System.out.println(Arrays.toString(new LeetCode_1_693_1().twoSum2(new int[]{2,7,11,15,16,17,18,19,20,21,22,23,24},91)));
    }
}
