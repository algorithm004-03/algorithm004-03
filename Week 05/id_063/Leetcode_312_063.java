/*
DP 求解

设dp(i, j) 是戳破下标从i到j的所有气球问题的最大收益
这个最大收益对应的戳气球方案中最后一个戳的位置为k, 那
k左边所有气球和k右边所有气球的戳法一定是最大收益的戳法
才能使得当前的戳法是最优的，这个就是本题最优子结构

枚举i, j之间所有可能的k， 每一个k都能算出来一个候选的最优戳法，计算过程又可以
利用已经计算出的子问题的结果进行加速，所有候选中收益最大的就是当前的最优解
一路递推就可以推出全局最优解


注意最后戳破k, 那么i-1 和 j+1位置的数会成为k位置数的最后的左右边界

dp(i, j) = max {
    dp(i, k-1) + nums[k]*nums[i-1]*nums[j+1] + dp(k, j)    (k = i,i+1,......j)
}
 */



class Solution {
    public int maxCoins(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int[][] dp = new int[len][len];

        for (int i = len-1 ; i >=0; i--) {
            for (int j = i; j < len; j++) {
                if (j == i) {
                    dp[i][j] = nums[i];
                    dp[i][j] *= (i-1 >= 0) ? nums[i-1] : 1;
                    dp[i][j] *= (i+1 < len) ? nums[i+1] : 1;
                    continue;
                }

                int maxVal = Integer.MIN_VALUE;
                int leftVal = (i-1 >= 0) ? nums[i-1] : 1;
                int rightVal = (j+1 < len) ? nums[j+1] : 1;
                for (int k = i; k <= j; k++) {
                    if (k == i) {
                        maxVal = Math.max(leftVal * nums[k] * rightVal + dp[k+1][j], maxVal);
                    } else if (k == j) {
                        maxVal = Math.max(dp[i][k-1] + leftVal * nums[k] * rightVal, maxVal);
                    } else {
                        maxVal = Math.max(dp[i][k - 1] + leftVal * nums[k] * rightVal + dp[k + 1][j], maxVal);
                    }
                }

                dp[i][j] = maxVal;
            }
        }

        return dp[0][len-1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxCoins(new int[]{3,1,5,8}));
    }
}