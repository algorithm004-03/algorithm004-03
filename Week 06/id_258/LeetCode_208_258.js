/*
 * @lc app=leetcode.cn id=208 lang=javascript
 *
 * [208] 实现 Trie (前缀树)
 */

// @lc code=start
/**
 * Initialize your data structure here.
 */
class Trie {
    constructor() {
        this.root = {};
    }

    insert(word) {
        let node = this.root;
        for(let i = 0; i < word.length; i++) {
            node = node[word[i]] = node[word[i]] || {};
            if(i === word.length - 1) node.isTerminal = true;
        }
    }

    search(word, isPrefix) {
        let node = this.root;
        for(let c of word) {
            if (!node[c]) return false;
            node = node[c];
        }

        return isPrefix || !!node.isTerminal;
    }

    startsWith(prefix) {
        return this.search(prefix, true);
    }
}

/** 
 * Your Trie object will be instantiated and called as such:
 * var obj = new Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */
// @lc code=end