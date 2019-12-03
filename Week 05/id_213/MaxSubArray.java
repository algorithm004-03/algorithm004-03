class Solution {
//思路 ：建立一个等长数组，遍历数组求和，依次比较某下标与前一个下标求到的和，
//较大的和存在遍历到的下标位置。然后遍历数组，获取存取和的数组中的最大值。
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (leng == 0) return 0;
        int[] dp = new int[len];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            if (dp[i - 1] >= 0) {
                dp[i] = dp[i - 1] +nums[i];
            } else {
                dp[i] = nums[i];
            }
        }
        int res = dp[0];
        for (int i = 1; i < len; i++ ) 
            res = Math.max(res, dp[i]);
        return res;
    }
}