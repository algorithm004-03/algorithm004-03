package test1.week5;

public class LeetCode_64_638 {

    /**
     * 最小路径和
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        //dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
        int [][] dp = grid;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0;i < row;i++){
            for (int j = 0;j < col;j++){
                if(i == 0 && j != 0){
                    dp[i][j] = dp[0][j] + grid[i][j-1];
                }else if (i != 0 && j == 0){
                    dp[i][j] = dp[i][0] + grid[i-1][0];
                }else if (i != 0 && j != 0){
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+ grid[i][j];
                }else {
                    dp[i][j] = grid[0][0];
                }

            }
        }
        return dp[row -1 ][col - 1];
    }
}
