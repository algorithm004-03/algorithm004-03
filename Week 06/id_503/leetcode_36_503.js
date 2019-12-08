/**
 * @param {character[][]} board
 * @return {boolean}
 */
var isValidSudoku = function (board) {
    if (!board) {
        return false;
    }

    const exists = {}; // 用来存储行、列、子数独已存在的值 (value -> true 字典)

    for (let i = 0; i < board.length; i++) {
        for (let j = 0; j < board[i].length; j++) {
            const val = board[i][j];
            if (val === '.') {
                continue;
            }

            const rowKey = i + "r" + val;
            const colKey = j + "c" + val;
            const boxKey = (parseInt(i / 3) * 3 + parseInt(j / 3)) + "b" + val
            if (exists[rowKey] || exists[colKey] || exists[boxKey]) {
                return false;
            }

            exists[rowKey] = true;
            exists[colKey] = true;
            exists[boxKey] = true;
        }
    }

    return true;
};