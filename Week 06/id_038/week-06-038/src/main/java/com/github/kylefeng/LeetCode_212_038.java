package com.github.kylefeng;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 212. 单词搜索 II
 *
 * @author kylefeng
 * @time 2019/11/24 15:32
 */
public class LeetCode_212_038 {

    public static List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        Node root = trie.root;
        for (String s : words) {
            trie.insert(s);
        }

        Set<String> result = new HashSet<>();
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                find(board, visited, i, j, m, n, result, root);
            }
        }
        return new LinkedList<>(result);
    }

    private static void find(char[][] board, boolean[][] visited, int i, int j, int m, int n,
                             Set<String> result, Node cur) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) {
            return;
        }

        cur = cur.child[board[i][j] - 'a'];
        visited[i][j] = true;
        if (cur == null) {
            visited[i][j] = false;
            return;
        }

        if (cur.isLeaf) {
            result.add(cur.val);
        }
        find(board, visited, i + 1, j, m, n, result, cur);
        find(board, visited, i, j + 1, m, n, result, cur);
        find(board, visited, i, j - 1, m, n, result, cur);
        find(board, visited, i - 1, j, m, n, result, cur);
        visited[i][j] = false;
    }

    static class Trie {
        public Node root = new Node();

        public void insert(String s) {
            Node cur = root;
            for (char c : s.toCharArray()) {
                if (cur.child[c - 'a'] == null) {
                    cur.child[c - 'a'] = new Node();
                    cur = cur.child[c - 'a'];
                } else {
                    cur = cur.child[c - 'a'];
                }
            }
            cur.isLeaf = true;
            cur.val = s;
        }
    }

    static class Node {
        public String val;
        public Node[] child = new Node[26];
        public boolean isLeaf = false;
    }

}
