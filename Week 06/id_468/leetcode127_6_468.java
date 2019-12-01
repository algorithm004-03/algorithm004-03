package week6;

import java.util.*;

/**
 * @program: leetcode
 * @description: 单词接龙
 * @author: 王瑞全
 * @create: 2019-11-2423:28
 **/


public class leetcode127_6_468 {
    //单项bfs
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;

        Queue<String> beginWords = new LinkedList<String>();
        HashSet<String> dictionary = new HashSet<String>();
        beginWords.offer(beginWord);

        for(String word : wordList){
            dictionary.add(word);
        }

        int length = 0;
        boolean flag = false;
        while(!beginWords.isEmpty() ){
            length++;
            int size = beginWords.size();
            for(int index = 0; index < size; index++){
                String curBegin = beginWords.poll();
                if(curBegin.equals(endWord)) {
                    return length;
                }
                char[] curword = curBegin.toCharArray();
                for(int i = 0; i<curBegin.length(); i++){

                    char ori = curword[i] ;
                    for(int j = 0; j<26; j++){
                        curword[i] = (char)('a' + j);
                        if(dictionary.contains(String.valueOf(curword))){
                            beginWords.offer(String.valueOf(curword));
                            dictionary.remove(String.valueOf(curword));
                        }
                    }
                    curword[i] = ori;
                }
            }

        }
        return 0;
    }
    //双向bfs
    public int ladderLengthdouble(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        Set<String> begin = new HashSet<String>();
        Set<String> end = new HashSet<String>();
        begin.add(beginWord);
        end.add(endWord);
        Set<String> dic = new HashSet<String>();
        for(String str : wordList) dic.add(str);

        int length = 1;
        while(!begin.isEmpty() && !end.isEmpty()){
            length++;
            if(begin.size() > end.size()){
                Set<String> temp = begin;
                begin = end;
                end = temp;
            }
            Set<String> tempset = new HashSet<String>();

            for(String bstr: begin){
                char[] bchars = bstr.toCharArray();
                for(int i = 0; i<bstr.length(); i++){
                    char ori = bchars[i];
                    for(char c = 'a' ; c<='z'; c++){
                        bchars[i] = c;
                        String newstr = String.valueOf(bchars);
                        if(end.contains(newstr)){
                            return length;
                        }

                        if(dic.contains(newstr)){
                            dic.remove(newstr);
                            tempset.add(newstr);
                        }

                    }
                    bchars[i] = ori;
                }
            }

            begin = tempset;
        }
        return 0;
    }
}
