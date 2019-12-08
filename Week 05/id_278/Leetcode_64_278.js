/**
 * 64. Minimum Path Sum
 * @param {number[][]} grid
 * @return {number}
 */
var minPathSum = function(grid) {
    let sum = [grid[0][0]];
    
    for (let i = 1; i < grid[0].length; ++ i) {
        sum[i] = grid[0][i] + sum[i - 1];
    }
    
    for (let j = 1; j < grid.length; ++ j) {
        for (let i = 0; i < grid[j].length; ++ i) {
            if (i === 0) {
                sum[i] += grid[j][i];
                continue;
            }
            sum[i] = grid[j][i] + Math.min(sum[i - 1], sum[i]);
        }
    }
    
    return sum[sum.length - 1];
};
