/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */

// @lc code=start
//DP 从左上角到右下角
class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length -1;
        int clos = grid[0].length -1;
        for(int i = 0 ;i<= rows;i++){
            for(int j =0 ;j <= clos;j++){
                if(i == 0 && j == 0){
                    grid[0][0] = grid[0][0];
                }else if(i == 0 && j > 0){
                    grid[0][j] = grid[0][j] + grid[0][j-1];
                }else if(j == 0 && i > 0 ){
                    grid[i][0] = grid[i][0] + grid[i-1][0];
                }else{
                    grid[i][j] = Math.min(grid[i-1][j], grid[i][j-1])+grid[i][j];
                }
            }
        }
        return grid[rows][clos];
    }
}
// @lc code=end

