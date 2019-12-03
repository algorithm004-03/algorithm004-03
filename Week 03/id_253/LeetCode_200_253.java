class Solution {
    public void sink(int i,int j,char[][] grid){
        int nr=grid.length;int nc = grid[0].length;
        if(i<0 || j<0 || i>=nr || j>=nc || grid[i][j] == '0') return;
        grid[i][j] = '0';
        sink(i-1,j,grid);
        sink(i+1,j,grid);
        sink(i,j-1,grid);
        sink(i,j+1,grid);
    }
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int nr=grid.length;int nc = grid[0].length;
        int islands=0;
        for(int i=0;i<nr;i++){
            for(int j=0;j<nc;j++){
                if(grid[i][j] == '1'){
                    islands++;
                    sink(i,j,grid);                    
                }
            }
        }
        return islands;
    }
}
