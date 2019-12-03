package test1.week3;

import javax.swing.*;
import java.util.*;

public class LeetCode_126_638 {

    public static void main(String[] args) {
        System.out.println(ladderLength("hit","cog",Arrays.asList("hot","dot","dog","lot","log","cog")));

    }

    public static List<List<String>> ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<String>();
        List<List<String>> res = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        if (!wordList.contains(endWord)) return res;
        queue.offer(beginWord);
        visited.add(beginWord);
        int step = 0;

        while (!queue.isEmpty()){
            step ++;
            int size = queue.size();
            List<String> strings = new LinkedList<>();
            for (int q = 0;q < size;q++){
                String temp = queue.poll();
                if (temp.equals(endWord)){
                    res.add(strings);
                    return res;
                }
                for(String word:wordList){
                    if (visited.contains(word))continue;
                    char[] wordArr = word.toCharArray();
                    char[] tempArr = temp.toCharArray();
                    int i = 0;
                    int diffCount = 0;
                    int[] nums = null;
                    for (char c:wordArr){
                        if (c != tempArr[i]){
                            diffCount ++;
                        }
                        if (diffCount > 1){
                            break;
                        }
                        i++;
                    }
                    if (diffCount == 1){
                        queue.offer(word);
                        visited.add(word);
                        strings.add(word);
                    }
                    System.out.println(strings);
                }
            }
        }
        return res;
    }
}
