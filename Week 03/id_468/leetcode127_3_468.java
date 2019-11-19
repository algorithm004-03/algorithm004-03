package week3;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: leetcode
 * @description: 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * @author: 王瑞全
 * @create: 2019-11-0219:01
 **/


public class leetcode127_3_468 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(endWord);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.remove();
                if (cur.equals(endWord)) return level + 1;
                for (int j = 0; j < cur.length(); j++) {
                    char[] word = cur.toCharArray();
                    for (char ch = 'a'; ch < 'z'; ch++) {
                        word[j] = ch;
                        String check = new String(word);
                        if (!check.equals(cur) && wordList.contains(check)) {
                            queue.add(check);
                            wordList.remove(check);
                        }
                    }

                }
            }
            level++;
        }
        return 0;

    }

}
