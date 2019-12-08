package com.leetcode.week06;

/**
 * Created by tim on 2019/11/23.
 */
public class TrieNode {
    public String val;
    public TrieNode[] child=new TrieNode[26];
    public boolean isLeaf=false;
    TrieNode(){
    }
}
