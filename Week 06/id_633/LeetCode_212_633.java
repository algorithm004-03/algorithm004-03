package lesson_14;

import java.util.ArrayList;
import java.util.List;

/**
 * 单词拼接 字典树实现时间复杂度分析
 * time: max(m * n + words.length * word.length * 4 ^ word.length)
 */
public class LeetCode_212_633 {

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {            // m
            for (int j = 0; j < board[0].length; j++) {     // n
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    public void dfs(char[][] board, int i, int j, TrieNode node, List<String> res) {
        char ch = board[i][j];
        if (ch == '#' || node.children[ch - 'a'] == null) {
            return;
        }
        node = node.children[ch - 'a'];
        if (node.word != null) {
            res.add(node.word);
            node.word = null;
        }

        board[i][j] = '#';
        if (i > 0)
            dfs(board, i - 1, j, node, res);
        if (j > 0)
            dfs(board, i, j - 1, node, res);
        if (i < board.length - 1)
            dfs(board, i + 1, j, node, res);
        if (j < board[0].length - 1)
            dfs(board, i, j + 1, node, res);
        board[i][j] = ch;
    }

    /**
     * O(words.length * word.length)
     * @param words
     * @return
     */
    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w: words) {                             // words.length
            TrieNode node = root;
            for (char ch: w.toCharArray()) {                // word.length
                int index = ch - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.word = w;
        }
        return root;
    }


    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

}
