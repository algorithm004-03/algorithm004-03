package com.hand.week6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description:
 * @version: 1.0
 * @author: xiantao.han@hand-china.com
 * @Date: 2019/11/24
 */
public class LeetCode_212_578 {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        Set<String> resultSet = new HashSet<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                helper(board, trie.head, i, j, m, n, visited, resultSet);
            }
        }
        return new ArrayList<>(resultSet);
    }

    private void helper(char[][] board, Trie.TrieNode node, int i, int j, int m, int n, boolean[][] visited, Set<String> resultSet) {
        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j]) return;
        node = node.children[board[i][j] - 'a'];
        if (node == null) return;
        if (node.word != null)
            resultSet.add(node.word);
        visited[i][j] = true;
        helper(board, node, i + 1, j, m, n, visited, resultSet);
        helper(board, node, i - 1, j, m, n, visited, resultSet);
        helper(board, node, i, j + 1, m, n, visited, resultSet);
        helper(board, node, i, j - 1, m, n, visited, resultSet);
        visited[i][j] = false;
    }

    class Trie {
        TrieNode head = new TrieNode();

        public void insert(String word) {
            TrieNode currentNode = head;
            for (char c : word.toCharArray()) {
                if (currentNode.children[c - 'a'] == null) currentNode.children[c - 'a'] = new TrieNode();
                currentNode = currentNode.children[c - 'a'];
            }
            currentNode.word = word;
        }

        class TrieNode {
            TrieNode[] children = new TrieNode[26];
            String word;
        }
    }
}
