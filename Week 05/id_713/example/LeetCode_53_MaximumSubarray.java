package id_713.example;

/**
 * 53. 最大子序和
 */
public class LeetCode_53_MaximumSubarray {

    /*
    给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

    示例:

    输入: [-2,1,-3,4,-1,2,1,-5,4],
    输出: 6
    解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

    进阶:

    如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/maximum-subarray
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。




    思路:

    1. 暴力 O(n ^ 2)
    2. DP
        a. 分治(子问题)  通常从后往前找, problem(i) = Max(sub(i - 1), 0) + problem(i)
        b. 状态数组定义
        c. DP方程       dp[i] = Max(dp[i - 1], 0]) + dp[i]

    最大子序列和 = 当前元素最大 或 包含之前以后最大

     */


    public int maxSubArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i - 1], 0) + nums[i];
        }

        int max = Integer.MIN_VALUE;
        for (int i : nums) {
            max = (i > max ? i : max);
        }

        return max;
    }
}
