package week4;

/**
 * @program: leetcode
 * @description: 最大正方形
 * @author: 王瑞全
 * @create: 2019-11-1823:38
 **/


public class leetcode221_5_468 {
    public int maximalSquare(char[][] matrix) {
        int maxArea = 0;
        if(matrix == null || matrix.length == 0) return maxArea;
        int dp[][] = new int[matrix.length][matrix[0].length];
        for(int j = 0; j < matrix[0].length; j++){
            dp[0][j] = matrix[0][j] - 48;
            maxArea = Math.max(maxArea,dp[0][j]);
        }
        for(int i=0; i<matrix.length; i++){
            dp[i][0] = matrix[i][0] - 48;
            maxArea = Math.max(maxArea,dp[i][0]);
        }
        for(int i=1; i<matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][j] - 48 == 0){
                    dp[i][j] = 0;
                }
                else{
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }
                maxArea = Math.max(maxArea,dp[i][j] * dp[i][j]);
            }
        }
        return maxArea;
    }
}
