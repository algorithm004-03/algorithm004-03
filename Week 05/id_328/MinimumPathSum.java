class MinimumPathSum {
    public int minPathSum(int[][] grid) {
      int lenX = grid.length;
       int lenY = grid[0].length;
       for(int i = 1 ; i < lenX;i++) {
           grid[i][0] += grid[i-1][0];
       }
       for(int j = 1 ; j < lenY;j++) {
           grid[0][j] += grid[0][j-1];
       }
       
       for(int k = 1 ; k < lenX ; k ++) {
           for(int l = 1; l < lenY; l++) {
               grid[k][l] += Math.min(grid[k-1][l],grid[k][l-1]);
           }
       }
       
       return grid[lenX-1][lenY-1];
    }
}