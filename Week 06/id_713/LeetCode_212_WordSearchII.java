package id_713;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 212. 单词搜索 II
 */
public class LeetCode_212_WordSearchII {
    /*
    给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。

    单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。

    示例:

    输入:
    words = ["oath","pea","eat","rain"] and board =
    [
      ['o','a','a','n'],
      ['e','t','a','e'],
      ['i','h','k','r'],
      ['i','f','l','v']
    ]

    输出: ["eat","oath"]

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/word-search-ii
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    public List<String> findWords(char[][] board, String[] words) {
        if (words == null || words.length == 0) return new ArrayList<>();
        if (words[0] == null || words[0].length() == 0) return new ArrayList<>();

        Trie trie = new Trie();
        TrieNode root = trie.root;
        for (String str : words) {
            trie.insert(str);
        }

        Set<String> result = new HashSet<>();
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board [0].length; j++) {
                find(board, visited, i, j, result, root);
            }
        }

        return new ArrayList<>(result);


    }

    private void find(char[][] board, boolean[][] visited, int i, int j, Set<String> result, TrieNode node) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) return;

        node = node.get(board[i][j]);
        visited[i][j] = true;

        if (node == null) {
            visited[i][j] = false; // 回溯
            return;
        }

        if (node.isEnd()) {
            result.add(node.val);
        }

        find(board, visited, i - 1, j, result, node);
        find(board, visited, i + 1, j, result, node);
        find(board, visited, i, j - 1, result, node);
        find(board, visited, i, j + 1, result, node);

        visited[i][j] = false; // 回溯


    }

    private class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char curr = word.charAt(i);
                if (!node.containsKey(curr)) {
                    node.put(curr, new TrieNode());
                }
                node = node.get(curr);
            }
            node.setEnd();
            node.val = word;
        }

        public TrieNode searchPrefix(String prefix) {
            TrieNode node = root;
            for (int i = 0; i < prefix.length(); i++) {
                char curr = prefix.charAt(i);
                if (!node.containsKey(curr)) return null;

                node = node.get(curr);
            }
            return node;
        }

        public boolean search(String word) {
            TrieNode node = this.searchPrefix(word);
            return node != null && node.isEnd();
        }

    }

    private class TrieNode {
        private TrieNode[] links;
        private final int R = 26;
        private boolean isEnd;
        private String val;

        public TrieNode() {
            links = new TrieNode[R];
        }

        public boolean containsKey(char ch) {
            return this.get(ch) != null;
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd() {
            this.isEnd = true;
        }
    }
}