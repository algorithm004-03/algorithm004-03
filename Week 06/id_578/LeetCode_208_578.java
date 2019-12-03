package com.hand.week6;

/**
 * @description:
 * @version: 1.0
 * @author: xiantao.han@hand-china.com
 * @Date: 2019/11/24
 */
public class LeetCode_208_578 {
    class Trie {

        class TrieNode {
            char data;
            TrieNode[] children = new TrieNode[26];
            boolean isEnd;

            public TrieNode(char data) {
                this.data = data;
            }

            public boolean hasNode(char node) {
                return children[node - 'a'] != null;
            }

            public TrieNode findNode(char node) {
                return children[node - 'a'];
            }

            public TrieNode createNode(char node) {
                children[node - 'a'] = new TrieNode(node);
                return children[node - 'a'];
            }
        }

        TrieNode head;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            head = new TrieNode('/');
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode currentNode = head;
            for (char c : word.toCharArray()) {
                if (currentNode.hasNode(c)) currentNode = currentNode.findNode(c);
                else currentNode = currentNode.createNode(c);
            }
            currentNode.isEnd = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode currentNode = head;
            for (char c : word.toCharArray()) {
                if (currentNode.hasNode(c)) currentNode = currentNode.findNode(c);
                else return false;
            }
            return currentNode.isEnd;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode currentNode = head;
            for (char c : prefix.toCharArray()) {
                if (currentNode.hasNode(c)) currentNode = currentNode.findNode(c);
                else return false;
            }
            return true;
        }
    }
}
