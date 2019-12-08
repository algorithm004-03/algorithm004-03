/**
 * @param {character[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */
var solve = function(board) {
    if (!board || board.length <= 0 || board[0].length <= 0) {
        return board;
    }

    // 先把与边界连通的 O 全换成 P
    for (var i = 0; i < board[0].length; ++i) {
        if (board[0][i] === "O") {
            fillP(0, i);
        }

        if (board[board.length - 1][i] === "O") {
            fillP(board.length - 1, i);
        }
    }

    for (var i = 1; i < board.length - 1; ++i) {
        if (board[i][0] === "O") {
            fillP(i, 0);
        }

        if (board[i][board[0].length - 1] === "O") {
            fillP(i, board[0].length - 1);
        }
    }

    // 然后将剩下的 O 换成 X
    for (var i = 0; i < board.length; ++i) {
        for (j = 0; j < board[0].length; ++j) {
            if (board[i][j] === "O") {
                board[i][j] = "X";
            }
        }
    }

    // 最后将 P 换回 O
    for (var i = 0; i < board.length; ++i) {
        for (j = 0; j < board[0].length; ++j) {
            if (board[i][j] === "P") {
                board[i][j] = "O";
            }
        }
    }

    return board;

    function fillP(x, y){
        if (x < 0 || y < 0) {
            return false;
        }

        if (x >= board.length || y >= board[0].length) {
            return false;
        }

        if (board[x][y] !== "O") {
            return false;
        }

        board[x][y] = "P";
        fillP(x + 1, y);
        fillP(x - 1, y);
        fillP(x, y + 1);
        fillP(x, y - 1);
    }
};
