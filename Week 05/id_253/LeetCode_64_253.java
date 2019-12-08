class Solution {
    public int minPathSum(int[][] grid) {
        if(grid.length == 0) return 0;
        int m = grid.length ; int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        int sum=dp[0][0];
        for(int i =1 ;i < m ;i++){
            sum+=grid[i][0];
            dp[i][0] = sum;
        }
        sum = dp[0][0];
        for(int i =1 ; i< n ; i++){
            sum+=grid[0][i];
            dp[0][i] = sum;;
        }
        int res = 0;
        for(int i =1 ; i < m ;i ++){
            for(int j =1 ;j<n ; j++){
                dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j])+grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }
}
