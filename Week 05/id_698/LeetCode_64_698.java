/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * @author gning (id=698)
 */

 public class LeetCode_64_698 {
     
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];

        for(int i=grid.length-1; i>=0; i--) {
            for(int j=grid[0].length-1; j>=0; j--) {
                if(i==grid.length-1 && j<grid[0].length-1) {
                    dp[i][j] = grid[i][j] + dp[i][j+1];
                }else if(i<grid.length-1 && j==grid[0].length-1) {
                    dp[i][j] = grid[i][j] + dp[i+1][j];
                }else if(i<grid.length-1 && j<grid[0].length-1) {
                    dp[i][j] = grid[i][j] + Math.min(dp[i+1][j], dp[i][j+1]);
                } else {
                    dp[i][j] = grid[i][j];
                }
            }
        }

        return dp[0][0];

    }


 }