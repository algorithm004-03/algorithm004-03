/**
 * @author northleaf
 * @create 2019年12月03日
 */
public class LeetCode_62_598 {

    /**
     * 使用动态规划的方式实现
     * @param col m列
     * @param row n行
     * @return
     */
    public int uniquePaths(int col, int row) {

        //n行m列
        int[][] dp = new int[col][row];

        for (int i = 0; i < row; i++) dp[0][i] = 1;
        for (int i = 0; i < col; i++) dp[i][0] = 1;
        for (int i = 1; i < col; i++) {
            for (int j = 1; j < row; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[col - 1][row - 1];
    }


    /**
     * 使用动态规范的方式
     *  起点在左上角
     *  同时返回的时候也是返回左上角的值
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths1(int m, int n) {
        int row = n;
        int col = m ;
        int[][] dp = new int[row][col];
        //根据动态规范的特点，从最后一格开始考虑
        //最后一行以及最后一列均为1，因为只有一条路可以走
        //最后一列
        for(int i = 0 ;i<row;i++){
            dp[i][col-1] = 1;
        }
        //最后一行
        for(int i = 0;i<col;i++){
            dp[row-1][i] =1;
        }
        //从终点向前推
        for(int i = row-2;i>=0;i--){
            for(int j = col-2;j>=0;j--){
                dp[i][j] = dp[i+1][j]+dp[i][j+1];
            }
        }
        return dp[0][0];
    }


}
