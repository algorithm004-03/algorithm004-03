
/*

动态规划

dp[i][j]表示从0,0位置到i,j 位置的最小路径和

dp[i][j] = min(dp[i][j-1], dp[i-1][j]) + gird[i][j]
 */


public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int len = grid[0].length;
        int[] old_dp = new int[len];
        int[] new_dp = new int[len];

        // 初始化第0行数据
        old_dp[0] = grid[0][0];
        for (int j = 1; j < len; j++) {
            old_dp[j] = old_dp[j-1] + grid[0][j];
        }

        for (int i = 1; i < grid.length; i++) {
            new_dp[0] = old_dp[0] + grid[i][0];
            for (int j = 1; j < len; j++) {
                new_dp[j] = Math.min(old_dp[j], new_dp[j-1]) + grid[i][j];
            }

            int[] tmp = old_dp; old_dp = new_dp; new_dp = tmp;
        }

        return old_dp[len-1];
    }
}
