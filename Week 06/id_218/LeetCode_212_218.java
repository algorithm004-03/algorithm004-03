package leetcode.week6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author eason.feng at 2019/11/19/0019 10:49
 **/
public class LeetCode_212_218 {

    LinkedList linkedList;

    public static void main(String[] args) {
        char[][] board = {{'o','a','a','n'}, {'e','t','a','e'}, {'i','h','k','r'}, {'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};
        LeetCode_212_218 leetCode_212_218 = new LeetCode_212_218();
        leetCode_212_218.findWords(board, words);
    }

    private List<String> res = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i]);
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                this.dfs(board, i, j, m, n, "", trie.root);
            }
        }
        return res;
    }

    private void dfs(char[][] board, int i, int j, int m, int n, String currentWord, Trie.TrieNode trie) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        Character temp = board[i][j];
        currentWord += temp;
        Trie.TrieNode node = trie.get(temp);
        if (node != null && node.isEnd) {
            if (!res.contains(currentWord)) {
                res.add(currentWord);
            }
        }
        if (node == null) {
            return;
        }
        board[i][j] = '@';
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        for (int k = 0; k < 4; k++) {
            int x = dx[k] + i, y = dy[k] + j;
            if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] != '@' && node.get(board[x][y]) != null) {
                this.dfs(board, x, y, m, n, currentWord, node);
            }
        }
        board[i][j] = temp;
    }

    class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            if (word == null || "".equals(word)) {
                return;
            }
            for (int i = 0; i < word.length(); i++) {
                Character c = word.charAt(i);
                if (!node.containsKey(c)) {
                    node.put(c, new TrieNode());
                }
                node = node.get(c);
            }
            node.setEnd();
        }

        class TrieNode {

            private TrieNode[] links;

            private final int R = 26;

            private boolean isEnd;

            public TrieNode() {
                links = new TrieNode[R];
            }

            public boolean containsKey(char ch) {
                return links[ch - 'a'] != null;
            }

            public TrieNode get(char ch) {
                return links[ch - 'a'];
            }

            public void put(char ch, TrieNode node) {
                links[ch - 'a'] = node;
            }

            public void setEnd() {
                isEnd = true;
            }

            public boolean isEnd() {
                return isEnd;
            }
        }
    }
}
