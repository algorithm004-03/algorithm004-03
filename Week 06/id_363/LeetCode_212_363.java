package com.test.leetcode.week06;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class SolutionWordSearchii212 {


    @Test
    public void test1() {
        char[][] board = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        String[] words = {"oath","pea","eat","rain"};

        char[][] board1 = {
                {'a'}
        };

        System.out.println(findWords2(board1, new String[]{"a"}));
        System.out.println(findWords2(board, words));
        System.out.println(findWords(board, words));
    }


    // 性能更好
    public List<String> findWords2(char[][] board, String[] words) {
        // 1. 创建trie树
        MyTrie myTrie = new MyTrie();
        for (String word : words) {
            myTrie.insert(word);
        }
        MyTrieNode root = myTrie.root;
        // 2. 查找字符串
        int row = board.length;
        int col = board[0].length;
        Set<String> result = new HashSet<>();
        for(int r = 0; r < row; r ++) {
            for (int c = 0; c < col ; c ++) {
                helper2(board, r, c, root, result);
            }
        }
        return new ArrayList<>(result);
    }


    int[] dr2 = {0, 1, 0, -1};
    int[] dc2 = {1, 0, -1, 0};
    // node 表示父节点的node
    private void helper2(char[][] board, int r, int c, MyTrieNode node, Set<String> result) {
        // termination
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] == '@') {
            return;
        }
        node = node.links[board[r][c] - 'a'];
        if (node == null) {
            return;
        }
        if (node.isEnd) {
            result.add(node.val);
        }
        // process
        char temp = board[r][c];
        board[r][c] = '@';
        for (int k = 0; k < 4; k ++) {
            helper2(board, r + dr2[k], c + dc2[k], node, result);
        }
        board[r][c] = temp;
        // drill down
        // reverse
    }

    /**
     * 给定二维网格和一个字典中的单词列表words
     * 找出所有同时在二维网格和字典中出现的单词的列表
     *
     * 1.循环网格
     * 判断第一个单词是否在列表中是前缀
     * 如果是，那么继续dfs，判断是否存在以这个单词为开始的单词
     *
     * // dfs
     * 获取当前单词，判断当前单词在trie树中是偶有前缀，如果有那么继续，如果是单词，那么返回这个单词
     *
     * @param board
     * @param words
     * @return
     */
    public List<String> findWords(char[][] board, String[] words) {
        // 1. 创建trie树
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        TrieNode root = trie.root;
        // 2. 查找字符串
        int row = board.length;
        int col = board[0].length;
        Set<String> result = new HashSet<>();
        for(int r = 0; r < row; r ++) {
            for (int c = 0; c < col ; c ++) {
                if (root.containsKey(board[r][c])) {
                    helper(board, "", r, c, trie, result);
                }
            }
        }
        return new ArrayList<>(result);
    }

    int[] dr = {0, 1, 0, -1};
    int[] dc = {1, 0, -1, 0};
    private void helper(char[][] board, String cur, int r, int c, Trie trie, Set<String> result) {
        // termination
        cur = cur + board[r][c];
        if (!trie.startsWith(cur)) {
            return;
        }
        if (trie.search(cur)) {
            result.add(cur);
        }

        // process
        char temp = board[r][c];
        board[r][c] = '@';
        for (int k = 0; k < 4; k ++) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length && board[nr][nc] != '@' ) {
                helper(board, cur, nr, nc, trie, result);
            }
        }
        // drill down
        // reverse
        board[r][c] = temp;
    }

}


class MyTrie {
    MyTrieNode root;

    public MyTrie () {
        root = new MyTrieNode();
    }

    public void insert(String word) {
        MyTrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.links[c - 'a'] == null) {
                node.links[c - 'a'] = new MyTrieNode();
            }
            node = node.links[c - 'a'];
        }
        node.isEnd = true;
        node.val = word;
    }

}

class MyTrieNode {
    String val = "";
    MyTrieNode[] links = new MyTrieNode[26];
    boolean isEnd = false;

}