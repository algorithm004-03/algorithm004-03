package id_713;

/**
 * 208. 实现 Trie (前缀树)
 */
public class LeetCode_208_ImplementTriePrefixTree {

    /*
    实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。

    示例:

    Trie trie = new Trie();

    trie.insert("apple");
    trie.search("apple");   // 返回 true
    trie.search("app");     // 返回 false
    trie.startsWith("app"); // 返回 true
    trie.insert("app");
    trie.search("app");     // 返回 true

    说明:

        你可以假设所有的输入都是由小写字母 a-z 构成的。
        保证所有输入均为非空字符串。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    /*
    思路:
    1. 字典顾名思义, 用数据结构存储字母, 随字母长度开辟层数, 并存储第N个字母

    举例(a-e), 存储ace, add

        坐标(如果有值赋值, ch - 'a', 如第一个字母a, 则值为0)
        a   b     c     d     e

        [0, null, null, null, null]
        [null, null, 2, 3, null]
        [null, null, null, 3, 4]

     */

    private class Trie {

        private TrieNode root;

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
                node = node.get(curr); // 进入到下一层
            }
            node.setEnd(); // 遍历完字符串后, 标记为结束

        }

        public boolean search(String word) {
            TrieNode node = this.searchPrefix(word);
            return node != null && node.getEnd();
        }

        public boolean startsWith(String prefix) {
            return this.searchPrefix(prefix) != null;

        }

        public TrieNode searchPrefix(String prefix) {
            TrieNode node = root;
            for (int i = 0; i < prefix.length(); i++) {
                char curr = prefix.charAt(i);
                if (!node.containsKey(curr)) return null;

                node = node.get(curr); // 进入到下一层
            }
            return node;
        }

        private class TrieNode {
            private TrieNode[] links;
            private final int R = 26; // 提示中写到a-z
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
                this.isEnd = true;
            }

            public boolean getEnd() {
                return this.isEnd;
            }
        }
    }


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

}
