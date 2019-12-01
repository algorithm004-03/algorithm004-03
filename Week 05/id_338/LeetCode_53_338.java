/**
 * @author Leesen
 * @date 2019/11/17 23:28
 * @Link https://leetcode-cn.com/problems/maximum-subarray/solution/dong-tai-gui-hua-fen-zhi-fa-python-dai-ma-java-dai/
 */
public class MaxSubArray_53 {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        int[] dp = new int[len];
        dp[0] = nums[0];
        for (int i=1; i<len; i++) {
            dp[i] = Math.max(0, dp[i-1]) + nums[i];
        }

        int maxSum = dp[0];
        for (int i=1; i<len; i++) {
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }
}
