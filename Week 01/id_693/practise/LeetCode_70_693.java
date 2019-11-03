package id_693.practise;

import java.util.HashMap;
import java.util.Map;

/**
 * @Desc 70.爬楼 https://leetcode-cn.com/problems/climbing-stairs/
 * @Auther 李雷(KyLin)
 * @Date 2019/10/17
 */
public class LeetCode_70_693 {
    //使用map来优化递归的重复项
    public int climbStairs(int n) {
        Map<Integer, Integer> map = new HashMap<>(n,1);
        return a(n,map);
    }

    private int a(int n,Map<Integer, Integer> map) {
        if (n == 1 || n == 2) {
            return n;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int ret = a(n - 1,map) + a(n - 2,map);
        map.put(n,ret);
        return ret;
    }

    // 使用数组来进行拉波西
    public int climbStairs2(int n) {
        if (n < 3) return n;
        int[] nums = new int[n];
        nums[0] = 1;
        nums[1] = 2;
        for (int i = 2; i < n; ++i) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[n - 1];
    }
    //使用递归

    public int climbStairs3(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int a = 1;
        int b = 2;
        int count = 2;
        for (int j = 3; j < n + 1; ++j) {
            count = a + b;
            a = b;
            b = count;
        }
        return count;
    }
}
