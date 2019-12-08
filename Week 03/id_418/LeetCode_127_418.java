package com.ljg.leetcode.week03.a_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * WordLadder
 */
public class WordLadder {

    public static void main(String[] args) {

    }

    private class Pair {
        String word;
        int level;

        Pair(String word, int level) {
            this.word = word;
            this.level = level;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int length = beginWord.length();

        Map<String, List<String>> dic = new HashMap<String, List<String>>();
        wordList.stream().forEach(word -> {
            for (int i = 0; i < length; i++) {
                String key = word.substring(0, i) + "*" + word.substring(i + 1, length);
                List<String> list = dic.getOrDefault(key, new ArrayList<String>());
                list.add(word);
                dic.put(key, list);
            }
        });

        Queue<Pair> queue = new LinkedList<Pair>();
        Pair beginPair = new Pair(beginWord, 1);
        queue.add(beginPair);

        List<String> visitted = new ArrayList<String>();
        visitted.add(beginWord);

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            String word = pair.word;
            int level = pair.level;

            for (int i = 0; i < length; i++) {
                String key = word.substring(0, i) + "*" + word.substring(i + 1, length);
                List<String> list = dic.get(key);

                if (list != null) {
                    for(String w : list) {
                        if (w.equals(endWord)) {
                            return level + 1;
                        } else {
                            if(visitted.contains(w)) {
                                continue;
                            }
                            Pair p = new Pair(w, level+1);
                            visitted.add(w);
                            queue.add(p);
                        }
                    }
                }
            }
        }

        return 0;
    }
}