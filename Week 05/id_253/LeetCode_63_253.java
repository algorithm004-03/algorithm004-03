class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;int n = obstacleGrid[0].length;
        if((m == 1 || n == 1)) {
            if(obstacleGrid[m-1][n-1]==1) return 0;
            if(obstacleGrid[m-1][n-1]==0 && obstacleGrid[0][0]==0) return 1;
            if(obstacleGrid[0][0]==1) return 0;
        }
        int[][] path = new int[m][n];
        path[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 1; i < m; i++) {
            path[i][0] = ((obstacleGrid[i][0] == 0 && path[i - 1][0] == 1) ? 1 : 0); 
        }
        for (int j = 1; j < n; j++) {
            path[0][j] = ((obstacleGrid[0][j] == 0 && path[0][j - 1] == 1) ? 1 : 0); 
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j] == 1){
                    path[i][j] = 0;
                }
                else if(obstacleGrid[i][j] == 0){
                    path[i][j] = path[i-1][j] + path[i][j-1];
                }
            }
        }
        return path[m-1][n-1];
    }
}
