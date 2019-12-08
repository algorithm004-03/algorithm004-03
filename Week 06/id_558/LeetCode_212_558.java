package Week05;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @see <a href="212">https://leetcode-cn.com/problems/word-search-ii/</a>
 * 单词搜索 II
 */
public class LeetCode_212_558 {
    private TrieNode root = new TrieNode();
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};

    public List<String> findWords(char[][] board, String[] words) {
        for (String s : words) {
            insert(s);
        }
        int rowLen = board.length;
        int colLen = board[0].length;
        Set<String> result = new HashSet<String>();
        boolean[][] visited = new boolean[rowLen][colLen];
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                search(i, j, rowLen, colLen, root, board, visited, result);
            }
        }
        return new ArrayList<String>(result);
    }

    private void search(int i, int j, int rowLen, int colLen, TrieNode node, char[][] board, boolean[][] visited, Set<String> result) {
        if (i < 0 || i >= rowLen || j < 0 || j >= colLen || visited[i][j]) return;
        node = node.get(board[i][j]);
        if (node == null) return;
        if (node.isEnd()) {
            result.add(node.getWord());
           // return;
        }
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            search(dx[k] + i, dy[k] + j, rowLen, colLen, node, board, visited, result);
        }
        visited[i][j] = false;
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        int len = word.length();
        TrieNode node = root;
        for (int i = 0; i < len; i++) {
            char c = word.charAt(i);
            if (!node.containsKey(c)) {
                node.put(c, new TrieNode());
            }
            node = node.get(c);
        }
        node.setEnd();
        node.setWord(word);
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = getTrieNode(word);
        return node != null && node.isEnd();
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = getTrieNode(prefix);
        return node != null;
    }

    private TrieNode getTrieNode(String word) {
        int len = word.length();
        TrieNode node = root;
        for (int i = 0; i < len; i++) {
            char c = word.charAt(i);
            if (!node.containsKey(c)) {
                return null;
            }
            node = node.get(c);
        }
        return node;
    }

    static class TrieNode {
        private final static int LEN = 26;
        private TrieNode[] nodes = new TrieNode[LEN];
        private String word;
        private boolean isEnd;

        public void put(char c, TrieNode node) {
            nodes[c - 'a'] = node;
        }

        public TrieNode get(char key) {
            return nodes[key - 'a'];
        }

        public boolean containsKey(char key) {
            return nodes[key - 'a'] != null;
        }

        public void setEnd() {
            this.isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public String getWord() {
            return this.word;
        }
    }

    public static void main(String[] args) {

      /*  String[] words = {"oath", "pea", "eat", "rain"};
        char[][] board =
                {
                        {'o', 'a', 'a', 'n'},
                        {'e', 't', 'a', 'e'},
                        {'i', 'h', 'k', 'r'},
                        {'i', 'f', 'l', 'v'}
                };*/
        String[] words = {"aba","baa","bab","aaab","aaa","aaaa","aaba"};
        char[][] board =
                {
                        {'a', 'b'},
                        {'a', 'a'}
                };

        LeetCode_212_558 test = new LeetCode_212_558();
        System.out.println(test.findWords(board, words));
    }
}
