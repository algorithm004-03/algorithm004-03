/**
 * T(n) = O(log(mn))
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function (matrix, target) {

    if (!matrix) {
        return false;
    }

    const m = matrix.length;
    if (m == 0) {
        return false;
    }
    const n = matrix[0].length;

    let left = 0;
    let right = m * n - 1; // 看成一个长数组

    // 二分查找
    while (left <= right) {
        const idx = Math.floor((left + right) / 2);

        const row = Math.floor(idx / n);
        const col = idx % n;
        const value = matrix[row][col];

        if (value === target) {
            return true;
        } else if (value < target) {
            left = idx + 1;
        } else {
            right = idx - 1;
        }
    }

    return false

};