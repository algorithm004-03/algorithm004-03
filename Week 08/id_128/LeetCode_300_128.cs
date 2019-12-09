public class Solution
{
    public int LengthOfLIS(int[] nums)
    {
        int length = nums.Length;
        if (length == 0) return 0;
        int[] dp = new int[length];
        int result = 0;
        for (int i = 0; i < dp.Length; i++)
        {
            dp[i] = 1;
        }
        for (int i = 0; i < length; ++i)
        {
            for (int j = 0; j < i; ++j)
            {
                if (nums[j] < nums[i]) dp[i] = Math.Max(dp[i], dp[j] + 1);
            }
            result = Math.Max(result, dp[i]);
        }
        return result;
    }
}