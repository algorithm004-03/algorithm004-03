package week6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 单词搜索
 * @author: 王瑞全
 * @create: 2019-11-2417:07
 **/


public class leetcode212_6_468 {
    //字典书解决问题
    private int row;
    private int col;
    private  int[] directionX={1,-1,0,0};
    private int[] directionY={0,0,1,-1};

    public List<String> findWords(char[][] board, String[] words) {
         List<String> res=new ArrayList<>();
         if(words==null||words.length==0){
             return res;
         }
         Trie trie=new Trie(words);
         this.row=board.length;
         this.col=board[0].length;
         for(int i=0;i<row;i++){
             for(int j=0;j<col;j++){
                 dfs(res,i,j,board,trie.root);
             }
         }
         return res;
    }
    private void dfs(List<String> res,int x,int y,char[][] board,TrieNode root){
        if(!root.children.containsKey(board[x][y])){
            return ;//没有在矩阵中找到前缀
        }
        TrieNode child=root.children.get(board[x][y]);
        if(child.word!=null){
            res.add(child.word);
            child.word=null;//置空避免重复
        }


        //回溯
        char temp=board[x][y];
        board[x][y]='0';
        for(int k=0;k<4;k++){
            int nextX=x+directionX[k];
            int nextY=y+directionY[k];
            if(nextX>=0 && nextX<row && nextY>=0 && nextY<col&&board[nextX][nextY]!='0'){
                dfs(res,nextX,nextY,board,child);
            }
        }
        board[x][y]=temp;


    }
    class TrieNode{
        String word;
        Map<Character,TrieNode> children;
        //这里不需要isWord，如果word!=null 那么这个节点就是一个单词

        public TrieNode(){
            this.word=null;
            this.children=new HashMap<>();
        }
    }
    class Trie{
        private TrieNode root;
        public Trie(String[] words){
            this.root=new TrieNode();
            for(String word:words){
                insert(word);
            }
        }
        private void insert(String word){
            TrieNode cur=root;
            Map<Character,TrieNode> curChildren=cur.children;
            for(int i=0;i<word.length();i++){
                char c=word.charAt(i);
                if(!curChildren.containsKey(c)){
                    TrieNode trieNode=new TrieNode();
                    curChildren.put(c,trieNode);
                }
                cur=curChildren.get(c);
                curChildren=cur.children;
            }
            cur.word=word;//直接把完整 的单词放在叶子节点上
        }
    }
}
