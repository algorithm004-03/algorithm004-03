/**
 * @author northleaf
 * @create 2019年12月05日
 */
public class LeetCode_64_598 {
    public int minPathSum(int[][] grid) {


        if(grid==null||grid.length<1){
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        //dp中存放最小路径之和
        int[][] dp = new int[grid.length][grid[0].length];
        //设置第一个格（左上角）的值
        dp[0][0] = grid[0][0];
        //处理第一行的值
        for(int i=1;i<col;i++){
            dp[0][i]=dp[0][i-1]+grid[0][i];
        }
        //处理第一列的值
        for(int i = 1;i<row;i++){
            dp[i][0] = dp[i-1][0]+grid[i][0];
        }

        //循环处理(从第二行第二列)开始
        for(int i = 1;i<row;i++){
            for(int j = 1;j<col;j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[row-1][col-1];
    }
}
