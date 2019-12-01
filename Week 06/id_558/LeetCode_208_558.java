package Week05;

/**
 * @see <a href="208">https://leetcode-cn.com/problems/implement-trie-prefix-tree/submissions/</a>
 * 实现 Trie (前缀树)
 */
public class LeetCode_208_558 {
    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public LeetCode_208_558() {
        root = new TrieNode();
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
    }

    public static void main(String[] args) {
        int num = 12345678;

        System.out.println(num & 123 & (~123));
    }
}
