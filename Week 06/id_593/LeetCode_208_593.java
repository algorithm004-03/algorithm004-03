/**
 * 208. 实现 LeetCode_208_593 (前缀树)
 * 实现一个 LeetCode_208_593 (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * <p>
 * 示例:
 * <p>
 * LeetCode_208_593 trie = new LeetCode_208_593();
 * <p>
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * 说明:
 * <p>
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jaryoung
 * @version 1.0
 */
public class LeetCode_208_593 {
    private TrieNode root;

    public LeetCode_208_593() {
        this.root = new TrieNode();
    }

    public static TrieNode buildTrie(String[] words) {
        LeetCode_208_593 trie = new LeetCode_208_593();
        for (String word : words) {
            trie.insert(word);
        }
        return trie.root;
    }

    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.get(c) == null) {
                current.put(c, new TrieNode());
            }
            current = current.get(c);
        }
        current.setEnd();
        current.setWord(word);
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private TrieNode searchPrefix(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.containsKey(c)) {
                current = current.get(c);
            } else {
                return null;
            }
        }
        return current;
    }
}

class TrieNode {
    private TrieNode[] nodes;
    private String word;
    private boolean isEnd;

    public TrieNode() {
        this.nodes = new TrieNode[26];
    }

    public boolean containsKey(char c) {
        return nodes[c - 'a'] != null;
    }

    public TrieNode get(char c) {
        return nodes[c - 'a'];
    }

    public void put(char c, TrieNode node) {
        nodes[c - 'a'] = node;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd() {
        this.isEnd = true;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }
}
