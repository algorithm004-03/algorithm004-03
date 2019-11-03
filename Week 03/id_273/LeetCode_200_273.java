//200. 岛屿数量

//解法1：深度优先
//思路：将二维数组中寻找到一个value = '1'的元素, 将其相邻value = '1'的元素都转换为0
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