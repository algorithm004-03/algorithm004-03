package week6;

/**
 * @program: leetcode
 * @description: Implement a trie with insert, search, and startsWith methods.
 * @author: 王瑞全
 * @create: 2019-11-2317:00
 **/


public class leetcode208_6_468 {
    public class Trie {
        class TrieNode {
            public TrieNode[] children;
            public boolean isWord;

            public TrieNode() {
                this.children = new TrieNode[26];
                this.isWord = false;
            }
        }

        private TrieNode root;

        //初始化你的数据结构
        public Trie(){
            root=new TrieNode();
        }
        //插入一个节点到字典树中
        public void insert(String word){
            TrieNode p=root;
            for(int i=0;i<word.length();i++){
                int index=(int)(word.charAt(i)-'a');
                if(p.children[index]==null){
                    p.children[index]=new TrieNode();
                }
                p=p.children[index];
            }
            p.isWord=true;
        }

        public boolean search(String word){
           TrieNode trieNode=find(word);
           return trieNode!=null&&trieNode.isWord;
        }
        //如果找到了前缀的单词就返回
        public boolean startWith(String prefix){
            return find(prefix)!=null;
        }


        private TrieNode find(String prefix){
            TrieNode p=root;
            for(int i=0;i<prefix.length();i++){
                int index=(int)(prefix.charAt(i)-'a');
                if(p.children[index]==null)return null;
                p=p.children[index];
            }
            return p;
        }
    }
}
