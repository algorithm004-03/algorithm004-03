// https://leetcode-cn.com/problems/unique-paths-ii/

/**
 * @param {number[][]} obstacleGrid
 * @return {number}
 */
var uniquePathsWithObstacles = function(obstacleGrid) {
    if (!obstacleGrid || !obstacleGrid.length) return 0;
    var n = obstacleGrid.length,
        m = obstacleGrid[0].length;
    if (obstacleGrid[0][0] === 1) return 0;
    obstacleGrid[0][0] = 1;
    for (var i = 1; i < n; i++) 
        obstacleGrid[i][0] = obstacleGrid[i][0] === 1 ? 0 : obstacleGrid[i - 1][0];
    for (var i = 1; i < m; i++) 
        obstacleGrid[0][i] = obstacleGrid[0][i] === 1 ? 0 : obstacleGrid[0][i - 1];
    for (var i = 1; i < n; i++) {
        for (var j = 1; j < m; j++) {
            if (obstacleGrid[i][j] === 1)
                obstacleGrid[i][j] = 0
            else 
                obstacleGrid[i][j] = obstacleGrid[i][j - 1] + obstacleGrid[i - 1][j];
        }
    }
    return obstacleGrid[n - 1][m - 1];
};


console.log(uniquePathsWithObstacles(
    [
        [0,0,0],
        [0,1,0],
        [0,0,0]
    ]
))