/**
 * @param {number[][]} grid
 * @return {number}
 */
var minPathSum = function (grid) {
  let l = grid.length, h = grid[0].length;
  let temp = [];
  for (let i = 0; i < l; i++) {
    temp[i] = [];
  }
  for (let i = 0; i < l; i++) {
    for (let j = 0; j < h; j++) {
      if (i == 0 && j == 0) {
        temp[i][j] = grid[i][j]
      }
      else if (i == 0) {
        temp[i][j] = temp[i][j - 1] + grid[i][j]
      }
      else if (j == 0) {
        temp[i][j] = temp[i - 1][j] + grid[i][j]
      }
      else {
        temp[i][j] = grid[i][j] + Math.min(temp[i][j - 1], temp[i - 1][j])
      }
    }
  }
  return temp[l - 1][h - 1]
};