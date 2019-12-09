package id_693.practise;

import org.junit.Assert;

/**
 * @Desc 53. 最大子序和	https://leetcode-cn.com/problems/maximum-subarray/
 * @Auther 李雷(KyLin)
 * @Date 2019/11/12
 */
public class LeetCode_53_693 {
    //理解了。但是没吃透啊。。。说是dp  但是没看出:
    // 1、如果累加 是负数，那么直接用当前值比较ans 取出最大值
    // 2、如果累加 不是负数，那么直接继续累加，同时比较ans 取出最大值
    // 他们都是选择最大值
    // 大于0 就继续累加，如果小于0 则就是自身了
    /*
    1、暴力：n^2
    2、DP：
        a. 分治（子问题： max_sum(i) = Max(max_sum(i - 1), 0) + a[i];
        b. 定义状态数组： f[i]
        c. DP方程：f[i] = Max(f(i - 1), 0) + a[i];

    1. dp问题：公式为：dp[i]  = max(nums[i],nums[i] + dp[i - 1])
    2. 最大子序和  = 当前元素自身最大，或者 包含之前后最大
     */
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int count = 0;
        for (int num : nums) {
            if (count > 0) {
                count += num;
            } else {
                count = num;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }

    public static void main(String[] args) {
        Assert.assertEquals(6, new LeetCode_53_693().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        Assert.assertEquals(-1, new LeetCode_53_693().maxSubArray(new int[]{-2, -1, -3, -4, -1, -2, -1, -5, -4}));
    }
}
