// https://leetcode-cn.com/problems/implement-trie-prefix-tree/

var Trie = function() {
    this.root = {};
};

/**
 * @param {string} word
 * @return {void}
 */
Trie.prototype.insert = function(word) {
    var node = this.root;
    for (char of word) {
        if (!node[char]) 
            node[char] = {};
        node = node[char];
    }
    node.isEnd = true;
};

/**
 * @param {string} word
 * @return {boolean}
 */
Trie.prototype.search = function(word) {
    var node = this.searchNode(word);
    return node ? node.isEnd === true : false;
};

/**
 * @param {string} prefix
 * @return {boolean}
 */
Trie.prototype.startsWith = function(prefix) {
    var node = this.searchNode(prefix);
    return node !== null;
};

Trie.prototype.searchNode = function(word) {
    var node = this.root;
    for (char of word) {
        if (node[char])
            node = node[char];
        else
            return null;
    }
    return node;
}

var trie = new Trie();
trie.insert("apple");
console.log(trie.search("apple")); // 返回 true
console.log(trie.search("app")); // 返回 false
console.log(trie.startsWith("app")); // 返回 true
trie.insert("app");
console.log(trie.search("app")); // 返回 true
