/**
 * @param {number[][]} grid
 * @return {number}
 */
var minPathSum = function (grid) {
    if (!grid && grid.length) {
        return 0;
    }
    if (!grid[0].length) {
        return 0;
    }

    const m = grid.length - 1;
    const n = grid[0].length - 1;
    const dp = [];
    for (let i = m; i >= 0; i--) {
        for (let j = n; j >= 0; j--) {
            if (i === m && j === n) {
                dp[j] = grid[i][j];
            } else if (i === m && j !== n) {
                dp[j] = grid[i][j] + dp[j + 1];
            } else if (i !== m && j === n) {
                dp[j] = grid[i][j] + dp[j];
            } else {
                dp[j] = grid[i][j] + Math.min(dp[j], dp[j + 1]);
            }
        }
    }

    return dp[0];
};