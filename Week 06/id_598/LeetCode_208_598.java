/**
 * @author northleaf
 * @create 2019年11月19日
 */
public class LeetCode_208_598 {
    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */




    class Trie {

        class TrieNode{
            //是否为结尾，默认为false
            boolean isEnd = false;
            //默认定义26叉
            int R = 26;
            //定义一个数组，用于存储
            TrieNode[] trieNodes ;

            /**
             * 构造方法
             */
            public TrieNode() {
                trieNodes = new TrieNode[26];
            }

            //插入字符
            public void put(char ch,TrieNode trieNode){
                trieNodes[ch - 'a'] = trieNode;
            }

            public TrieNode get(char ch){
                return trieNodes[ch - 'a'];
            }

            public boolean contains(char ch){
                return trieNodes[ch - 'a'] != null;
            }

            /**
             * 设置结尾
             */
            public void setEnd(){
                isEnd = true;
            }
        }


        TrieNode root ;

        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode node = root;

            for(int i = 0; i<word.length();i++){
                char ch = word.charAt(i);
                if(!node.contains(ch)){
                    node.put(ch,new TrieNode());
                }
                node = node.get(ch);
            }

            node.setEnd();

        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode node = root;
            for(int i =0;i<word.length();i++){
                char ch = word.charAt(i);
                if(!node.contains(ch)){
                    return false;
                }
                node = node.get(ch);
            }

            return node.isEnd;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for(int i =0;i<prefix.length();i++){
                char ch = prefix.charAt(i);
                if(!node.contains(ch)){
                    return false;
                }
                node = node.get(ch);
            }

            return true;
        }
    }
}
