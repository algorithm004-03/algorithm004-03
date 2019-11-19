/*
DP 算法求解
dp[i][j] 表示以i位置 开始 j位置结束的最大和区间
dp[i][j] 要么是左边界向左移拓展出来的，要么是右边界向右移拓展出来的

所以 dp[i][j] = max( max(dp[i+2][j], dp[i+3][j]) + nums[i], max(dp[i][j-2], dp[i][j-3]) + nums[j] )
如果abs(j - i) == 1 或者是  abs (n - j + i) == 1 对应的状态是不存在的, 对应的dp[i][j]表示为-1
最后求所有dp[i][j]的最大值


 */

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int n = nums.length;

        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            // 最后三行数据特殊处理，其他行按照递推公式进行
            if (i == n - 1) {
                for (int j = 0; j <= n-1; j++) {
                    dp[i][j] = (j == n-1) ? nums[n-1] : -1;
                }
                continue;
            }

            if (i == n - 2) {
                for (int j = 0; j <= n-1; j++) {
                    dp[i][j] = (j == n-2) ? nums[n-2] : -1;
                }
                continue;
            }

            if (i == n - 3) {
                for (int j = 0; j <= n-1; j++) {
                    if (j == i) {
                        dp[i][j] = nums[j];
                    } else if ((j == i+2) && (Math.abs(n-j+i) != 1)) {
                        dp[i][j] = nums[j] + nums[i];
                    } else {
                        dp[i][j] = -1;
                    }
                }
                continue;
            }

            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    dp[i][j] = nums[i];
                    continue;
                }

                if ((j < i) || (Math.abs(j-i) == 1) || (Math.abs(n-j+i) == 1)) {
                    dp[i][j] = -1;
                    continue;
                }

                dp[i][j] = -1;

                if ( (j-3 >= 0) && (dp[i][j-3] != -1)) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j-3] + nums[j]);
                }

                if ( (j-2 >= 0) && (dp[i][j-2] != -1)) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j-2] + nums[j]);
                }

                if (dp[i+2][j] != -1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i+2][j] + nums[i]);
                }

                if (dp[i+3][j] != -1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i+3][j] + nums[i]);
                }
            }
        }

        int maxVal = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxVal = Math.max(maxVal, dp[i][j]);
            }
        }

        return maxVal;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().rob(new int[] {2,3,2}));
    }
}