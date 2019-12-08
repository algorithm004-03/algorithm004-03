// https://leetcode-cn.com/problems/surrounded-regions/

/**
 * @param {character[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */
var solve = function (board) {
    if (!board || !board.length) return board;

    var n = board.length,
        m = board[0].length,
        dx = [-1, 1, 0, 0],
        dy = [0, 0 , -1, 1],
        parent = [];

    for (var i = 0; i <= n * m; i++)
        parent[i] = i;

    for (var i = 0; i < n; i++) {
        for (var j = 0; j < m; j++) {
            if (board[i][j] === 'O') {
                if (i === 0 || i === (n - 1) || j === 0 || j === (m - 1)) {
                    unio(i * m + j, n * m)
                } else {
                    for (var k = 0; k < dx.length; k++) {
                        if (board[i + dx[k]][j + dy[k]] === 'O')
                            unio(i * m + j, (i + dx[k]) * m + (j + dy[k]))
                    }
                }
            }
        }
    }
    
    for (var i = 0; i < n; i++) {
        for (var j = 0; j < m; j++) {
            if (board[i][j] === 'O' && find(i * m + j) !== m * n)
                board[i][j] = 'X';
        }
    }

    function unio (i, j) {
        var rootI = find(i),
            rootJ = find(j);
        if (rootI === rootJ) return;
        parent[rootI] = rootJ;
    }

    function find (i) {
        return parent[i] === i ? parent[i] : find(parent[i])
    }
};

var arr = [
    ["X", "X", "X", "X"],
    ["X", "O", "O", "X"],
    ["X", "X", "O", "X"],
    ["X", "O", "X", "X"]];
solve(arr);
console.log(arr);