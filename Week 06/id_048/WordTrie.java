package com.leetcode.week06;

/**
 * Created by tim on 2019/11/23.
 */
public class WordTrie {
    public TrieNode root=new TrieNode();
    public void insert(String s){
        TrieNode cur=root;
        for(char c:s.toCharArray()){
            if(cur.child[c-'a']==null){
                cur.child [c-'a'] = new TrieNode();
                cur=cur.child[c-'a'];
            }else
                cur=cur.child [c-'a'];
        }
        cur.isLeaf=true;
        cur.val=s;
    }

}
