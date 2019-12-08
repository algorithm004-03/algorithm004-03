/**
 * @param {number[][]} grid
 * @return {number}
 */
var minPathSum = function(grid) {
    var dp = new Array(grid.length);

    for (var i = 0; i < grid.length; ++i){
        for (var j = 0; j < grid[0].length; ++j) {
            if (i !== 0 && j !== 0) {
                dp[j] = (dp[j - 1] < dp[j] ? dp[j - 1] : dp[j]) + grid[i][j];
            }
            else if (i === 0 && j !== 0) {
                dp[j] = dp[j - 1] + grid[i][j];
            }
            else if (i !== 0 && j === 0) {
                dp[j] = dp[j] + grid[i][j];
            }
            else if (i === 0 && j === 0){
                dp[j] = grid[i][j];
            }
        }
    }

    return dp[grid[0].length - 1];
};
