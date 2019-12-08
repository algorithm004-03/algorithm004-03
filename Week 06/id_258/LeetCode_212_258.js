/*
 * @lc app=leetcode.cn id=212 lang=javascript
 *
 * [212] 单词搜索 II
 */

// @lc code=start
/**
 * @param {character[][]} board
 * @param {string[]} words
 * @return {string[]}
 */
var findWords = function (board, words) {
    let res = [];

    function buildTrie() {
        const root = {};
        for (let w of words) {
            let node = root;
            for (let c of w) {
                if (node[c] == null) node[c] = {};
                node = node[c]
            }
            node.word = w;
        }
        return root;
    }

    function search(node, i, j) {
        if (node.word != null) {
            res.push(node.word);
            node.word = null;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;

        if (node[board[i][j]] == null) return;

        const c = board[i][j];
        board[i][j] = '#';
        search(node[c], i + 1, j);
        search(node[c], i - 1, j);
        search(node[c], i, j + 1);
        search(node[c], i, j - 1);
        board[i][j] = c;
    }

    const root = buildTrie();

    for (let i = 0; i < board.length; i++) {
        for (let j = 0; j < board[0].length; j++) {
            search(root, i, j);
        }
    }
    return res;
};
// @lc code=end