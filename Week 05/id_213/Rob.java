class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        int ans = Math.max(dp[0][0], dp[0][1]);
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0] + dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
            ans = Max.max(Math.max(dp[i][0],dp[i][1]), ans);
        }
        return ans;
    }
}