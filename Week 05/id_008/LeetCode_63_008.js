/**
 * @param {number[][]} obstacleGrid
 * @return {number}
 */
var uniquePathsWithObstacles = function(obstacleGrid) {
    if (obstacleGrid.length === 0) {
        return 0;
    }

    var total = new Array(obstacleGrid[0].length).fill(0);
    total[0] = 1;

    for (var i = 0; i < obstacleGrid.length; ++i) {
        for (var j = 0; j < obstacleGrid[0].length; ++j) {
            if (obstacleGrid[i][j] === 1) {
                total[j] = 0;
            }
            else if (j) {
                total[j] += total[j - 1];
            }
        }
    }

    return total.pop();
};
