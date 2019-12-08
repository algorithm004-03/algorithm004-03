/**
 * @param {character[][]} board
 * @param {string[]} words
 * @return {string[]}
 */
var findWords = function (board, words) {
    if (!board.length || !board[0].length || !words.length) {
        return [];
    }

    // 构建单词字典树
    const wordsTrie = {}
    for (const w of words) {
        let node = wordsTrie;
        for (const c of w) {
            node = node[c] = node[c] || {};
        }

        node.word = w;
    }

    const res = [];
    const m = board.length;
    const n = board[0].length;
    // 搜索方向：右，上、左、下（四联通）
    const dx = [1, 0, -1, 0];
    const dy = [0, 1, 0, -1];

    // DFS
    var search = (i, j, trie) => {
        if (i < 0 || i >= m || j < 0 || j >= n) { // 边界判断
            return;
        }

        const c = board[i][j];
        const node = trie[c];
        if (!node) { // 判断是否包含字符（也包括 “#”）
            return;
        }

        if (node.word) { // 查找到单词
            res.push(node.word);

            node.word = null; // 防止重复；需要继续搜索，因为有相同前缀的情况，比如："ab", "abc"
        }

        board[i][j] = "#" // 标识已经查找过了

        for (let d = 0; d < dx.length; d++) {
            const ix = i + dx[d];
            const jx = j + dy[d];

            search(ix, jx, node)
        }

        board[i][j] = c; // 还原状态（回溯）
    }

    for (let i = 0; i < board.length; i++) {
        for (let j = 0; j < board[i].length; j++) {

            search(i, j, wordsTrie);
        }
    }

    return res;
};