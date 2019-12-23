/**
 * @param {number} n
 * @return {string[][]}
 */
var solveNQueens = function (n) {
  let result = new Array(n);
  let results = [];
  let dfs = (row, column) => {
    let leftColumn = column - 1;
    let rightColumn = column + 1;
    for (let i = row - 1; i >= 0; i--) {
      if (result[i] == column) {
        return false;
      }
      if (leftColumn >= 0 && result[i] == leftColumn) {
        return false;
      }
      if (rightColumn < n && result[i] == rightColumn) {
        return false;
      }
      leftColumn--;
      rightColumn++;
    }
    return true;
  }
  let format = (result) => {
    let tmpResult = [];
    for (let i = 0; i < n; i++) {
      let str = '';
      for (let j = 0; j < n; j++) {
        if (result[i] == j) {
          str += 'Q';
        } else {
          str += '.';
        }
      }
      tmpResult.push(str);
    }
    return tmpResult;
  }
  let Nqueens = (row) => {
    if (row == n) {
      results.push(format(result));
      return;
    }
    for (let j = 0; j < n; j++) {
      if (dfs(row, j)) {
        result[row] = j;
        Nqueens(row + 1)
      }
    }
  }
  Nqueens(0);
  return results;
};
