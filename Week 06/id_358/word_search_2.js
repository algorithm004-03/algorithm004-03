/**
 * @param {character[][]} board
 * @param {string[]} words
 * @return {string[]}
 */
 class TrieNode  {
    constructor() {
        this.isEnd = false;
        this.children = {}
    }
}

let root = null;
function Trie() {
    root = new TrieNode()
}
Trie.prototype.insert = function(word) {
    let node = root;
    for(let i = 0; i < word.length; i++) {
        if(!node.children[word[i]]) {
            node.children[word[i]] = new TrieNode()
        }
        node = node.children[word[i]]
    }
    node.isEnd = true;
}

Trie.prototype.searchPrefix = function(word) {
    let node = root;
    for(let i = 0; i < word.length; i++) {
        if(node.children[word[i]]) {
            node = node.children[word[i]]
        } else {
            return null;
        }
    }
    return node;
}

Trie.prototype.search = function(word) {
    const prefix = this.searchPrefix(word)
    return prefix !== null && prefix.isEnd
}
Trie.prototype.startWith = function(word) {
    return this.searchPrefix(word) !== null;
}
var findWords = function(board, words) {
    const trie = new Trie();
    words.forEach(word => trie.insert(word))
    const m = board.length;
    const n = board[0].length;
    // 方向向量
    const dx = [-1,1,0,0]
    const dy = [0,0,-1,1]
    const result = [];
    for(let i = 0; i < m; i++) {
        for(let j = 0; j < n; j++) {
            bfs(i,j,'')
        }
    }
    return result;

    function bfs(i, j, currStr) {
        let restore = board[i][j]
        currStr += restore;
        if(trie.search(currStr) && result.indexOf(currStr) < 0) {
            result.push(currStr)
        }
        if(!trie.startWith(currStr)) { // 剪枝
            return;
        }
        board[i][j] = '#' // 临时改为特殊字符，用于防止重复访问
        // drill down 四个方向
        for(let k = 0; k < 4; k++) {
            let _i = dx[k] + i;
            let _j = dy[k] + j;
            if(_i >=0 && _j >=0 && _i < m && _j < n && board[_i][_j] !== '#') {
                bfs(_i, _j, currStr)
            }
        }
        board[i][j] = restore;
    }
};