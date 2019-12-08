package com.test.leetcode.week06;

import org.junit.Test;


public class SolutionImplementTrie208 {


    @Test
    public void test1() {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // 返回 true
        System.out.println(trie.search("app"));     // 返回 false
        System.out.println(trie.startsWith("app")); // 返回 true
        trie.insert("app");
        System.out.println(trie.search("app"));     // 返回 true
    }
}


class Trie {

    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    // 时间复杂度: O(m) 空间复杂度O(m) m表示字符串的长度
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (Character c : word.toCharArray()) {
            if (!node.containsKey(c)) {
                node.putNode(c, new TrieNode());
            }
            node = node.getNode(c);
        }
        node.setEnd();
    }

    // 时间复杂度: O(m) 空间复杂度O(1) m表示字符串的长度
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return false;
        }
        return searchPrefix(prefix) != null;
    }

    private TrieNode searchPrefix(String prefix) {
        TrieNode node = root;
        for(char c : prefix.toCharArray()) {
            if (node.containsKey(c)) {
                node = node.getNode(c);
            } else {
                return null;
            }
        }
        return node;
    }
}

class TrieNode {

    private TrieNode[] links;
    private final int total = 26;
    private Boolean isEnd;

    // 注意初始化
    public TrieNode() {
        links = new TrieNode[total];
        isEnd = false;
    }

    public Boolean containsKey (char c) {
        return links[c - 'a'] != null;
    }

    public void putNode (char c, TrieNode node) {
        links[c - 'a'] = node;
    }

    public TrieNode getNode(char c) {
        return links[c - 'a'];
    }

    public Boolean isEnd () {
        return isEnd;
    }
    public void setEnd() {
        this.isEnd = true;
    }
}
