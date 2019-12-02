/*
思路

定义状态dp[i] 为以nums[i]作为结尾因子的最大乘积

可能出现两种情况
    1. nums[i]单独作为一个序列
    2. nums[i] 跟nums[i-1] 连成一片
        dp[i] 的值就依赖于前面0 到 i-1的数值全部乘起来的最大值和最小值，因为nums[i]本身有正有负，
        nums[i] 为正 dp[i]就应该是前面序列乘积最大值和num[i]相乘，否则就应该是前面序列最小值
        和num[i]相乘，所以一维的状态不够用

        定义 dp[i][0] 为 以 i 结尾的序列的乘积最小值
            dp[i][1] 为 以 i 结尾的序列的乘积最大值

            i从 0 到 nums.length进行迭代，每轮迭代更新最大值和最小值
            最后答案就是 max( dp[0][1], dp[1][1], ... dp[n-1][1] )


 */


class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int dp0 = nums[0];
        int dp1 = nums[0];
        int max, min;
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                dp0 = dp1 = 0;
                continue;
            }

            max = min = nums[i];

            if (nums[i] > 0) {
                max = Math.max(max, dp1 * nums[i]);
                min = Math.min(min, dp0 * nums[i]);
            } else {
                max = Math.max(max, dp0 * nums[i]);
                min = Math.min(min, dp1 * nums[i]);
            }

            dp0 = min;
            dp1 = max;

            result = Math.max(result, dp1);
        }

        return result;
    }
}