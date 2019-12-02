/**
 * @param {number[][]} M
 * @return {number}
 */
var findCircleNum = function (M) {
  let n = M.length;
  if (n == 0) {
    return 0;
  }
  let count = 0;
  let dfs = (i) => {
    for (let j = 0; j < n; j++) {
      if (M[i][j] == 1 && !visited[j]) {
        visited[j] = true;
        dfs(j);
      }
    }
  }
  let visited = {};
  for (let i = 0; i < n; i++) {
    if (!visited[i]) {
      dfs(i);
      count++;
    }
  }
  return count;
};