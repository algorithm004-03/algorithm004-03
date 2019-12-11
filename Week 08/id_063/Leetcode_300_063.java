/*
 动态规划

 dp[i]表示以i位置的字符结尾的上升子序列最大长度
 迭代到i位置时候，找nums[i]前面所有比它小的元素的下标x, 找dp[x]最大的一个，dp[i] = dp[x] + 1
 反之，i位置数字只能自己组成一个序列，dp[i] = 1

 max(dp[0 : nums.length - 1]) 就是最后答案


*/

class Solution {
    public int lengthOfLIS(int[] nums) {
        if ((nums == null) || (nums.length == 0)) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = 1;

        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }

            dp[i] = max;
            result = Math.max(result, dp[i]);
        }

        return result;
    }
/*
    public static void main(String[] args) {
        new Solution().lengthOfLIS(new int[] {10,9,2,5,3,7,101,18});
    }
 */
}