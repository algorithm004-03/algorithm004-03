/**
 * @author northleaf
 * @create 2019年12月03日
 */
public class LeetCode_63_598 {
    /**
     * obstacleGrid中的1代表障碍物，0代表空位
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid==null || obstacleGrid.length < 1){
            return 0;
        }

        //获取行与列
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        //定义一个二维数组
        //1代表有一个位置可走，0代表无路可走
        int[][] dp  = new int[row][col];

        //设定最后一个位置的值
        dp[row-1][col-1] = obstacleGrid[row-1][col-1] == 1 ? 0 : 1 ;
        //设定最后一行的值
        for(int i = col-2;i>=0;i--){
            //最后一行的值，从未尾向前推，如果给定的数组中为1，则为0(无路），否则等于它的下一位的值
            dp[row-1][i]= obstacleGrid[row-1][i] == 1 ? 0  : dp[row-1][i+1];
        }
        //设定最后一列的值
        for(int i = row - 2;i >= 0;i--){
            dp[i][col-1]=obstacleGrid[i][col-1] == 1 ? 0 : dp[i+1][col-1];
        }

        for(int i = row - 2;i>=0;i--){
            for(int j = col - 2;j>=0 ;j--){
                dp[i][j]=obstacleGrid[i][j] ==1 ?  0 : (dp[i+1][j]+dp[i][j+1]);
            }
        }

        return dp[0][0];
    }
}
