package com.test.leetcode.week03;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * done 20191103
 * todo 20191104
 * todo 20191105
 * todo 20191109
 */
public class SolutionLadderLength127 {


    @Test
    public void test1() {
        System.out.println(ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
        System.out.println(ladderLength_bfs("hot", "dog", Arrays.asList("hot","dog")));
        System.out.println(ladderLength_bfs("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
    }


    /**
     * BFS:每个单词特殊处理一下：找到词库里面所有编辑距离是1的单词放入到队列中
     * DFS:找到编辑距离是1的词继续向下dfs
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength_bfs(String beginWord, String endWord, List<String> wordList) {
        // 1. 词库特殊处理
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Map<String, List<String>> workMap = new HashMap<>();
        wordList.forEach(word -> {
            for (int i = 0; i < word.length(); i ++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, word.length());
                List<String> candidate = workMap.getOrDefault(newWord, new LinkedList<>());
                candidate.add(word);
                workMap.put(newWord, candidate);
            }
        });
        // 2. 使用队列
        LinkedList<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> visited = new HashSet();
        visited.add(beginWord);
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size -- > 0) {
                // 判断当前单词是否和endWord 相等1
                String cur = queue.poll();
                if (cur.equals(endWord)) {
                    return step;
                }
                // 找编辑距离是1的单词加入到队列中
                for (int i = 0; i < cur.length(); i ++) {
                    String newWord = cur.substring(0, i) + "*" + cur.substring(i + 1);
                    List<String> probablityWords = workMap.getOrDefault(newWord, new LinkedList<>());
                    for (String pword : probablityWords) {
                        if (visited.contains(pword)) {
                            continue;
                        }
                        // 已经加入到队列中的数据就不在处理了
                        visited.add(pword);
                        queue.add(pword);
                    }
                }
            }
            step ++;
        }
        return 0;
    }


    /**
     * 1.DFS 查找当前start 和 wordList 里面编辑距离是1的词，继续dfs
     * 返回的是转换序列的长度
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        int res = helper(beginWord, endWord, wordList, 0);
        return Integer.MAX_VALUE == res ? 0 : res + 1;
    }

    private int helper(String beginWord, String endWord, List<String> wordList, int step) {
        // 递归终止条件
        if (beginWord.equals(endWord)) {
            return step;
        }
        int res = Integer.MAX_VALUE;
        if (!wordList.contains(endWord)) {
            return res;
        }
        // 处理当前层
        for (String word : wordList) {
            int diff = computeEditDistance(word, beginWord);
            if (diff != 1) {
                continue;
            }
            if (endWord.equals(word)) {
                return step + 1;
            }
            List<String> tempWordList = new LinkedList<>(wordList);
            tempWordList.remove(word);
            // 下探到下一层
            res = Math.min(helper(word, endWord, tempWordList, step + 1), res);
        }
        // 清理当前层
        return res;
    }

    private int computeEditDistance(String word, String beginWord) {
        int count = 0;
        for (int i = 0; i < word.length();i ++) {
            if (word.charAt(i) != beginWord.charAt(i)) {
                count ++;
                if (count > 1) {
                    break;
                }
            }
        }
        return count;
    }


}
