// https://leetcode-cn.com/problems/n-queens/

/**
 * @param {number} n
 * @return {string[][]}
 */
// 回溯+剪枝
var solveNQueens = function (n) {
    var result = [];
    placeQueens(result, n);
    return result;
};

function placeQueens (result, col, board = [], row = 0) {
    if (row === col) {
        result.push(board.map(b_col => '.'.repeat(b_col) + 'Q' + '.'.repeat(col - b_col - 1)))
    }
    for (var i = 0; i < col; i++) {
        if (!board.some((b_col, b_row) => i === b_col || (i - b_col) === (row - b_row) || (b_col + b_row) === (i + row))) {
            board.push(i);
            placeQueens(result, col, board, row + 1);
            board.pop();
        }
    }
}

console.log(solveNQueens(4));
console.log(solveNQueens(5));