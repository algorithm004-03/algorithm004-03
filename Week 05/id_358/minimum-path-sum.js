/** 直接在原数组上遍历不需要额外的空间
 * gri[i,j] 表示从左上角到右下角的最小路径值
 * grid[i][j] = min(grid[i+1][j], grid[i][j+1]) + grid[i][j]
 * @param {number[][]} grid
 * @return {number}
 */
 var minPathSum = function(grid) {
    for(let i = grid.length-1; i >=0; i--) {
        for(let j = grid[0].length-1; j >=0; j--) {
            if(i !== grid.length -1 && j != grid[0].length - 1) {
                grid[i][j] = Math.min(grid[i+1][j], grid[i][j+1]) + grid[i][j]
            } else if(i === grid.length - 1 && j !== grid[0].length - 1) {
                grid[i][j] = grid[i][j+1]+ grid[i][j]
            } else if(i !== grid.length - 1 && j === grid[0].length - 1) {
                grid[i][j] = grid[i+1][j] + grid[i][j]
            }

        }   
    }
    return grid[0][0]
};