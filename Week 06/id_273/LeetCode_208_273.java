//208. 实现Trie字典树

//解法1：多叉树法
public class ImplementTrie {
	//Trie树的节点结构
    class TrieNode{
        private TrieNode[] root;//底层采用数组定义
        private final int R = 26;//length
        private boolean isEnd;//标识截止到当前节点, 是否已经成功查找到单词

        public TrieNode() {
            this.root = new TrieNode[R];
        }
		
		//判断当前节点数组中是否包含字符c
        public boolean containsKey(char c) {
            return root[c - 'a'] != null;
        }
		
		//获取到字符c所在的节点数组
        public TrieNode get(char c) {
            return root[c - 'a'];
        }

		//在当前节点数组中添加字符c的节点数组, 并返回当前节点数组
        public TrieNode put(char c, TrieNode node) {
            return root[c - 'a'] = node;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return this.isEnd;
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public ImplementTrie() {
        this.root = new TrieNode();
    }

    /** 在字典树中添加word */
	//思路：迭代判断word的每一个字符是否存在于当前节点数组中：
	//			若exit：则node更新为当前节点数组中, 该字符所在index的子节点
	//			若not exit：则在当前节点数组中新建一个对应该字符的节点数组
	//		最后在末尾节点添加End标识
    public void insert(String word) {
        TrieNode node = this.root;
        for (char c : word.toCharArray()) {
            if (!node.containsKey(c)) {
                node.put(c, new TrieNode());
            }
            node = node.get(c);
        }
        node.setEnd();
    }

    /** 判断word是否存在于当前字典树 */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    /** 判断prefix是否是当前字典树的前缀字符串 */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

	//查找word在字典树中对应的尾结点
    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.containsKey(c)) {
                node = node.get(c);
            } else {
                return null;
            }
        }
        return node;
    }
}