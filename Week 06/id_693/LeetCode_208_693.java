package id_693;

/**
 * @Desc 208. 实现 Trie (前缀树)	https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 * @Auther 李雷(KyLin)
 * @Date 2019/11/18
 */
public class LeetCode_208_693 {
    class Trie {
        TreeNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            this.root = new TreeNode('#');
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TreeNode temp = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (temp.elements[ch - 'a'] == null) {
                    temp.elements[ch - 'a'] = new TreeNode(ch);
                }
                temp = temp.elements[ch - 'a'];
            }
            temp.setEnable();
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TreeNode temp = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (temp.elements[ch - 'a'] == null) {
                    return false;
                }
                temp = temp.elements[ch - 'a'];
            }
            return temp.isEnable();
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TreeNode temp = root;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                if (temp.elements[ch - 'a'] == null) {
                    return false;
                }
                temp = temp.elements[ch - 'a'];
            }
            return true;
        }

        class TreeNode {
            TreeNode[] elements;
            char val;
            boolean isEnable = false;

            public TreeNode(char val) {
                this.val = val;
                this.elements = new TreeNode[26];
            }

            void setEnable() {
                isEnable = true;
            }

            boolean isEnable() {
                return isEnable;
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
