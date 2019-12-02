/**
 * 题目： 实现 Trie (前缀树)
 * 语言： JavaScript
 * 执行结果： 打败了87.30%的用户
 * */



/**
 * Initialize your data structure here.
 */
var Trie = function() {
    this.isEnd = false;
    this.nextWords = {};
};

/**
 * Inserts a word into the trie.
 * @param {string} word
 * @return {void}
 */
Trie.prototype.insert = function(word) {
    let curr = this;
    const wordArr = word.split('');
    if(wordArr.length === 0) return;

    for(let i=0;i<wordArr.length;i++) {
        if(!curr.nextWords.hasOwnProperty(wordArr[i])) {
            curr.nextWords[wordArr[i]] = new Trie();
        }

        curr = curr.nextWords[wordArr[i]];
    }

    curr.isEnd = true;
};

/**
 * Returns if the word is in the trie.
 * @param {string} word
 * @return {boolean}
 */
Trie.prototype.search = function(word) {
    let curr = this;
    const wordArr = word.split('');

    for(let i=0;i<wordArr.length;i++) {
        if(!curr.nextWords[wordArr[i]]) return false;
        curr = curr.nextWords[wordArr[i]];
    }

    return curr.isEnd;
};

/**
 * Returns if there is any word in the trie that starts with the given prefix.
 * @param {string} prefix
 * @return {boolean}
 */
Trie.prototype.startsWith = function(prefix) {
    let curr = this;
    const wordArr = prefix.split('');

    for(let i=0;i<wordArr.length;i++) {
        if(!curr.nextWords[wordArr[i]]) return false;
        curr = curr.nextWords[wordArr[i]];
    }

    return true;
};

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = new Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */
