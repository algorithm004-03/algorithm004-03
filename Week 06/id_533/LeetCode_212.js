// https://leetcode-cn.com/problems/word-search-ii/

/**
 * @param {character[][]} board
 * @param {string[]} words
 * @return {string[]}
 */
var findWords = function(board, words) {
    var n = board.length,
        m = board[0].length,
        root = {},
        result = [];
    for (word of words) {
        var node = root;
        for (char of word) {
            if (!node[char])
                node[char] = {}
            node = node[char];
        }
        node.word = word;
    }
    for (var i = 0; i < n; i++) {
        for (var j = 0; j < m; j++) {
            find(i, j, root);
        }
    }
    return result;

    function find (i, j, node) {
        if (node.word) {
            result.push(node.word);
            node.word = null;
        }
        if (i < 0 || i >= n || j < 0 || j >=m) return;
        if(!node[board[i][j]]) return;
        var dx = [-1, 1, 0, 0],
            dy = [0, 0, -1, 1];
        var tmp = board[i][j];
        board[i][j] = '#';
        for (var k = 0; k < dx.length; k++) 
            find(i + dx[k], j + dy[k], node[tmp])
        board[i][j] = tmp;
    }
};

var result = findWords([
    ['o','a','a','n'],
    ['e','t','a','e'],
    ['i','h','k','r'],
    ['i','f','l','v']
], ["oath","pea","eat","rain"]); 
console.log(result)