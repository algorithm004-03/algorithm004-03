/*
求和为coins的组合数
设dp[i][j]为前i种数字能凑出的和为j的组合数量

dp[i][j] = dp[i-1][j] + dp[i-1][j-coins[i]] + dp[i-1][j-coins[i]*2] ........

dp[i][j]在计算时候可以利用dp[i][j-coins[i]]进行加速
 */


class Solution {
    public int change(int amount, int[] coins) {
        if (coins.length == 0) {
            return amount == 0 ? 1 : 0;
        }

        int[] dp_new = new int[amount + 1];
        int[] dp_old = new int[amount + 1];

        //i = 0初始化
        for (int j = 0; j <= amount; j++) {
            dp_old[j] = (j % coins[0] == 0) ? 1 : 0;
        }

        for (int i = 1; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                dp_new[j] = dp_old[j];
                if (j >= coins[i]) {
                    dp_new[j] += dp_new[j - coins[i]];
                }
            }

            int[] tmp = dp_old; dp_old = dp_new; dp_new = tmp;
        }

        return dp_old[amount];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().change(5, new int[] {1,2,5}));
    }
}