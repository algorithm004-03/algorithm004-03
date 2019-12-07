/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
const searchMatrix = (matrix, target) => {
  let m = matrix.length;
  if (m === 0) {
    return false;
  }
  let n = matrix[0].length;

  let left = 0;
  let right = m * n - 1;
  let pivotIdx, pivotElement;
  while (left <= right) {
    pivotIdx = parseInt((left + right) / 2, 10);
    pivotElement = matrix[parseInt(pivotIdx / n, 10)][pivotIdx % n];
    if (target === pivotElement) {
      return true;
    } else {
      if (target < pivotElement) {
        right = pivotIdx - 1;
      } else {
        left = pivotIdx + 1;
      }
    }
  }
  return false;
};
