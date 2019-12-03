/*
DP算法

dp[i]表示前i个位置都经过之后能够覆盖到的最远距离
dp[i] = max (dp[i-1], i + nums[i])


 */

class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return true;
        }

        int dp = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (dp >= nums.length - 1) {
                return true;
            }

            if (i > dp) {
                return false;
            }

            dp = Math.max(dp, i + nums[i]);
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canJump(new int[] {2,3,1,1,4}));
    }
}
