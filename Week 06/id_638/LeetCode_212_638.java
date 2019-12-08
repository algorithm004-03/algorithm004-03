package test1.Week6;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class LeetCode_212_638 {
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    /**
     * 单词搜索
      * @param board
     * @param words
     * @return
     */
    public List<String> findWords(char[][] board, String[] words) {
        wordTrie myTrie=new wordTrie();
        trieNode root=myTrie.root;
        for(String s:words)
            myTrie.insert(s);
        Set<String> result =new HashSet<>();
        int m=board.length;
        int n=board[0].length;
        boolean [][]visited=new boolean[m][n];
        for(int i=0;i<board.length; i++){
            for (int j = 0; j < board [0].length; j++){
                find(board,visited,i,j,m,n,result,root);
            }
        }
        return new LinkedList<String>(result);
    }
    private void find(char [] [] board, boolean [][]visited,int i,int j,int m,int n,Set<String> result,trieNode cur){
        if(i<0||i>=m||j<0||j>=n||visited[i][j])
            return;
        cur=cur.child[board[i][j]-'a'];
        visited[i][j]=true;
        if(cur==null)
        {
            visited[i][j]=false;
            return;
        }
        if(cur.isLeaf)
        {
            result.add(cur.val);
        }
        for(int f = 0;f < 4;f++){
            find(board,visited,i+dx[f],j+dy[f],m,n,result,cur);
        }
        visited[i][j]=false;
    }


    /**
     * 字典树
     */
    public class wordTrie{
        public trieNode root=new trieNode();
        public void insert(String s){
            trieNode cur=root;
            for(char c:s.toCharArray()){
                if(cur.child[c-'a']==null){
                    cur.child [c-'a'] = new trieNode();
                    cur=cur.child[c-'a'];
                }else
                    cur=cur.child [c-'a'];
            }
            cur.isLeaf=true;
            cur.val=s;
        }
    }

    /**
     * 字典树结点
     */
  public  class trieNode{
        public String val;
        public trieNode[] child=new trieNode[26];
        public boolean isLeaf=false;

        trieNode(){

        }

    }

}


