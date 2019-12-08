package com.github.kylefeng;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 127. 单词接龙
 *
 * @author kylefeng
 * @time 2019/11/1 14:33
 */
public class LeetCode_127_038 {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null) {
            return 0;
        }

        if (beginWord.isEmpty() || endWord.isEmpty()) {
            return 0;
        }

        if (wordList == null || wordList.isEmpty()) {
            return 0;
        }

        Set<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord)) {
            return 0;
        }


        Set<Character> charSet = new HashSet<>();
        for (String word : wordList) {
            char[] chars = word.toCharArray();
            for (char c : chars) {
                charSet.add(c);
            }
        }
        return check(beginWord, endWord, charSet, wordSet);
    }

    private static int check(String str, String endWord, Set<Character> charSet, Set<String> wordSet) {
        int res = 1;
        LinkedList<String> queue = new LinkedList<>();
        queue.add(str);

        while (queue.size() != 0) {
            res++;

            int size = queue.size();
            while (size-- > 0) {
                str = queue.poll();
                char[] chars = str.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char original = chars[i];
                    for (Character c : charSet) {
                        chars[i] = c;
                        String toBeChecked = new String(chars);
                        if (!wordSet.contains(toBeChecked)) {
                            continue;
                        }

                        if (toBeChecked.equals(endWord)) {
                            return res;
                        }

                        queue.add(toBeChecked);
                        wordSet.remove(toBeChecked);
                    }
                    chars[i] = original;
                }
            }
        }
        return 0;
    }
}
