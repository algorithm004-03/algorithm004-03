/**
 * @author eazonshaw
 * @date 2019/11/22  11:28
 *
 * 题目：实现Trie树
 */
public class LeetCode_208_243 {

    class Trie {

        //root
        private TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            //初始化一个空节点
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            char[] wordArray = word.toCharArray();
            int len = wordArray.length;
            TrieNode currNode = root;
            for(int i = 0;i<len;i++){
                if(currNode.containsKey(wordArray[i])){
                    if(i == len - 1){
                        currNode.get(wordArray[i]).setEnd(true);
                    }else{
                        currNode = currNode.get(wordArray[i]);
                    }
                }else{
                    TrieNode tmpNode = new TrieNode();
                    if(i == len - 1){
                        tmpNode.setEnd(true);
                    }
                    currNode.put(wordArray[i],tmpNode);
                    currNode = tmpNode;
                }
            }
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            boolean rs = false;
            char[] wordArray = word.toCharArray();
            int len = wordArray.length;
            TrieNode currNode = root;
            for(int i = 0;i<len;i++){
                if(currNode.containsKey(wordArray[i])){
                    currNode = currNode.get(wordArray[i]);
                    if(i == len - 1){
                        rs = currNode.isEnd();
                    }
                }else{
                    break;
                }
            }
            return rs;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            boolean rs = false;
            char[] wordArray = prefix.toCharArray();
            int len = wordArray.length;
            TrieNode currNode = root;
            for(int i = 0;i<len;i++){
                if(currNode.containsKey(wordArray[i])){
                    currNode = currNode.get(wordArray[i]);
                    if(i == len - 1){
                        rs = true;
                    }
                }else{
                    break;
                }
            }
            return rs;
        }
    }
    //字典树节点
    class TrieNode{

        //节点数组
        private TrieNode[] link;
        //是否为末位节点
        private boolean end;

        public TrieNode() {
            link = new TrieNode[26];
            end = false;
        }
        //containsKey
        public boolean containsKey(char letter){
            return link[letter - 'a'] != null;
        }
        //setValue
        public void put(char letter , TrieNode node){
            link[letter - 'a'] = node;
        }
        //getValue
        public TrieNode get(char letter){
            return link[letter - 'a'];
        }
        //setEnd
        public void setEnd(boolean end){
            this.end = end;
        }
        //isEnd
        public boolean isEnd(){
            return this.end;
        }
    }

}
