/**
 * @param {character[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */
var solveSudoku = function (board) {
    if (!board) {
        return;
    }

    solve(board);
};

/**
 * @param {character[][]} board
 * @return {boolean} 
 */
function solve(board) {
    for (let i = 0; i < board.length; i++) {
        for (let j = 0; j < board[i].length; j++) {
            if (board[i][j] === ".") {
                for (let n = 1; n < 10; n++) {
                    const val = n.toString();
                    if (isValid(board, i, j, val)) {

                        board[i][j] = val;

                        if (solve(board)) {
                            return true;
                        }

                        board[i][j] = ".";
                    }
                }

                return false;
            }
        }
    }

    return true
}

/**
 * @param {character[][]} board
 * @param {number} rowIndex
 * @param {number} colIndex
 * @param {string} val
 * @return {boolean} 
 */
function isValid(board, rowIndex, colIndex, val) {

    for (let i = 0; i < 9; i++) {
        const boxRow = parseInt(rowIndex / 3) * 3 + parseInt(i / 3);
        const boxCol = parseInt(colIndex / 3) * 3 + parseInt(i % 3);

        if (board[rowIndex][i] === val ||
            board[i][colIndex] === val ||
            board[boxRow][boxCol] === val) {
            return false;
        }
    }

    return true;
}