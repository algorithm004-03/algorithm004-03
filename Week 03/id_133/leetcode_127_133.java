
//leetcode 题号127 单词接龙

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

public class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();
    
        int len = 1;
        // int strLen = beginWord.length();
        HashSet<String> visited = new HashSet<String>();
        
        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
    
            Set<String> temp = new HashSet<String>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();
    
                for (int i = 0; i < chs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);
    
                        if (endSet.contains(target)) {
                            return len + 1;
                        }
    
                        if (!visited.contains(target) && wordList.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        chs[i] = old;
                    }
                }
            }
    
            beginSet = temp;
            len++;
        }
        
        return 0;
    }

    public static void main(String[] args) {

        String beginWord = "hit";
        String endWord   = "cog";
        List<String> wordList = new ArrayList<String>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        Solution solution = new Solution();
        int result = solution.ladderLength(beginWord, endWord, wordList);
        System.out.println(result);
    }
}