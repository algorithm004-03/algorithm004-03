package study.week08;

/**
 * 最长上升子序列
 * @author Lukas
 * @since 2019/12/8 18:31
 **/
public class LeetCode_300_138 {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length==0)
            return 0;
        //动态方程:dp[i]=max(dp[j])+1,0≤j<i,dp第i个元素之前的最长升序序列
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            int temp = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {//判断是否升序
                    temp = Math.max(temp,dp[j]);
                }
            }
            dp[i] = temp +1;
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
