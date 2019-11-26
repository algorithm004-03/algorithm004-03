/*
 * @lc app=leetcode.cn id=64 lang=javascript
 *
 * [64] 最小路径和
 */

// @lc code=start
/**
 * @param {number[][]} grid
 * @return {number}
 */
var minPathSum = function(grid) {
    if(!grid || grid.length === 0) return false;

    let dp = [];
    for(let i = 0; i < grid.length; i++) {
        
    }

    for(let i = grid.length - 1; i >= 1; i--) {
        for(let j = grid[i].length -1 ; j >= 1; j--) {
            dp[i][j] = Math.min(grid[i-1][j], grid[i][j-1]) + grid[i][j];
        }
    }

    return dp[0][0];
};
// @lc code=end

