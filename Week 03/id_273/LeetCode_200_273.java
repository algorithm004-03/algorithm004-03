//200. 岛屿数量

//解法1：深度优先		执行用时击败约97%
//思路：遍历二维数组, 每遍历到一个为‘1’的坐标, 将它与周围相邻的‘1’转换为‘0’, 这样第二次遍历时就可以排除掉第一次记录的岛屿
class Solution {
    public int numIslands(char[][] grid) {
        int nums = 0;
        for (int i = 0; i<grid.length; i++) {
            for (int j = 0; j<grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    nums++;
                }
            }
        }
        return nums;
    }
    
    private void dfs(char[][] grid, int col, int row) {
        if (col < 0 || row < 0 || col >= grid.length || row >= grid[0].length || grid[col][row] == '0') return;
        grid[col][row] = '0';
        dfs(grid,col - 1, row);
        dfs(grid, col + 1, row);
        dfs(grid, col, row - 1);
        dfs(grid, col, row + 1);
    }
}