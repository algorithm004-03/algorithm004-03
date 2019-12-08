/*
简单字典树实现，没什么特别算法

 */

class Trie {
    private class TrieNode {
        TrieNode[] edges;
        boolean isEnd;

        TrieNode() {
            edges = new TrieNode[26];
            isEnd = false;
        }

        TrieNode addSubNode(char ch) {
            if (edges[ch-'a'] != null) {
                return edges[ch - 'a'];
            }

            edges[ch-'a'] = new TrieNode();
            return edges[ch - 'a'];
        }

        TrieNode nextNode(char ch) {
            return edges[ch - 'a'];
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curNode = root;
        for (int i = 0; i < word.length(); i++) {
            curNode = curNode.addSubNode(word.charAt(i));
        }

        curNode.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curNode = root;
        for (int i = 0; i < word.length(); i++) {
            curNode = curNode.nextNode(word.charAt(i));
            if (curNode == null) {
                return false;
            }
        }

        return curNode.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            curNode = curNode.nextNode(prefix.charAt(i));
            if (curNode == null) {
                return false;
            }
        }

        return true;
    }
}
