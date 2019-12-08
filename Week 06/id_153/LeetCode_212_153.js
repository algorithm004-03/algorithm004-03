/**
 * @param {character[][]} board
 * @param {string[]} words
 * @return {string[]}
 */
var findWords = function(board, words) {
  class TrieNode {
    constructor() {
      this.END = false;
      this.children = {};
    }
  }

  let root = null;
  let Trie = function() {
    root = new TrieNode();
  };

  Trie.prototype.insert = function(word) {
    let currNode = root;
    for (let i = 0; i < word.length; i++) {
      if (currNode.children[word[i]] === undefined) {
        currNode.children[word[i]] = new TrieNode();
      }
      currNode = currNode.children[word[i]];
    }
    currNode.END = true;
  };

  // 初始化变量
  let m = board.length;
  let n = board[0].length;

  // 初始化字典树
  let wordsTrie = new Trie();
  for (let i = 0; i < words.length; i++) {
    wordsTrie.insert(words[i]);
  }

  // DFS 搜索
  let boardDFS = (i, j, currStr, currNode) => {
    if (currNode.END) {
      result.push(currStr);
      currNode.END = false;
    }

    if (i < 0 || j < 0 || i === m || j === n) {
      return;
    }

    const restore = board[i][j];
    if (restore === "#" || !currNode.children[restore]) {
      return;
    }
    // 前进
    board[i][j] = "#";
    currStr += restore;
    boardDFS(i - 1, j, currStr, currNode.children[restore]);
    boardDFS(i + 1, j, currStr, currNode.children[restore]);
    boardDFS(i, j - 1, currStr, currNode.children[restore]);
    boardDFS(i, j + 1, currStr, currNode.children[restore]);
    // 回溯
    board[i][j] = restore;
  };
  // 寻找结果
  let result = [];
  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      boardDFS(i, j, "", root);
    }
  }
  return result;
};
