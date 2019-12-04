class Solution {
    public int maximalSquare(char[][] matrix) {

        int rows = matrix.length;
        if (matrix == null) {
            return 0;
        }
        if (rows == 0) {
            return 0;
        }
        int column = matrix[0].length;
        int dp[][] = new int[rows][column];
        int max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
                } else {
                    if(matrix[i][j]=='1'){
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1])+1;
                    }                }

                max = Math.max(max, dp[i][j]);

            }
        }

        return max * max;
    }
}