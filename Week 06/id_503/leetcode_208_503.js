/**
 * Initialize your data structure here.
 */
class Trie {
    constructor() {
        this.root = new TrieNode();
    }
    /**
     * Inserts a word into the trie.
     * @param {string} word
     * @return {void}
     */
    insert(word) {
        let node = this.root;

        for (let c of word) {
            node = node.links[c] = node.links[c] || new TrieNode();
        }

        node.isEnd = true;
    }
    /**
     * Returns if the word is in the trie.
     * @param {string} word
     * @return {boolean}
     */
    search(word) {
        const node = this.searchNode(word);

        return !!(node && node.isEnd)
    }
    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     * @param {string} prefix
     * @return {boolean}
     */
    startsWith(prefix) {
        return !!this.searchNode(prefix);
    }

    /**
     * Returns a TrieNode object if there is any word search ends in the trie, or returns null.
     * @param {string} word 
     * @returns {TrieNode}
     */
    searchNode(word) {
        if (!word) {
            return null;
        }

        let node = this.root;
        for (const c of word) {
            if (!(node = node.links[c])) {
                return null;
            }
        }

        return node;
    }
}

/**
 * Node of a trie
 */
class TrieNode {

    constructor() {
        this.links = {};
        this.isEnd = false;
    }
}


/**
 * Your Trie object will be instantiated and called as such:
 * var obj = new Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */