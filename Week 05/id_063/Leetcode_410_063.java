/*

Dp算法求解

dp(i, j) 表示下标为i或者i之前的所有数字分成j组，所有分法中每组数据总和的最大值的下界
dp(i, j) =   min(   max( dp(i-1, j-1), nums[j] )
                    max( dp(i-2, j-1), nums[j] + nums[j-1] )
                    max( dp(i-3, j-1), nums[j] + nums[j-1] + nums[j-2] )
                    ......
                )

注意只有j<=i+1时候dp(i, j) 才有意义
 */

public class Solution {
    public int splitArray(int[] nums, int m) {
        if (nums.length < m || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];

        // j = 1 时候初始化第一列, 数组只分一组
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            dp[i] = sum;
        }

        for (int j = 2; j <= m; j++) {
            for (int i = nums.length-1; i >= 0; i--) {
                if (j > (i+1)) {
                    dp[i] = -1;      //  无意义数值
                    continue;
                }

                sum = 0;
                int minVal = Integer.MAX_VALUE;
                for (int k = 1; j-1 <= i-k+1; k++) {
                    sum += nums[i-k+1];
                    minVal = Math.min(minVal, Math.max(dp[i-k], sum));
                }
                dp[i] = minVal;
            }
        }

        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().splitArray(new int[] {1,4,4}, 3));
    }
}