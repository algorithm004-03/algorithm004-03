package com.code.week3;


import javafx.util.Pair;

import java.util.*;

/**
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出: 5
 *
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      返回它的长度 5。
 * 示例 2:
 *
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * 输出: 0
 *
 * 解释: endWord "cog" 不在字典中，所以无法进行转换
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-ladder
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_127_748_ladderLength {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {


        // 所有单词都有相同的长度
        int L = beginWord.length();

        HashMap<String, ArrayList<String>> allComboDict = new HashMap<String, ArrayList<String>>();

        wordList.forEach(
                word -> {
                    for (int i = 0; i < L; i++) {
                        // key是通用式
                        // value是所有类别
                        String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                        ArrayList<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<String>());
                        transformations.add(word);
                        allComboDict.put(newWord, transformations);
                    }
                });

        // Queue for BFS
        // pair:一对k/v   map：多对k/v
        Queue<Pair<String, Integer>> Q = new LinkedList<Pair<String, Integer>>();
        Q.add(new Pair(beginWord, 1));

        // Visited to make sure we don't repeat processing same word.
        HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
        visited.put(beginWord, true);

        while (!Q.isEmpty()) {

            // 取出单词
            Pair<String, Integer> node = Q.remove();
            String word = node.getKey();
            int level = node.getValue();

            for (int i = 0; i < L; i++) {

                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

                // 找到相同的通用的value进行比较
                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<String>())) {

                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }

                    // 将不符合的所有没用过的value加入到List中
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        Q.add(new Pair(adjacentWord, level + 1));
                    }


                }
            }
        }

        return 0;

    }





    public int ladderLength1(String beginWord, String endWord, List<String> wordList ){

        // 0. 定义变量
        int L = beginWord.length(); // 题目限制条件，所有单词字符串长度一致
        HashMap<String, ArrayList<String>> commonWords = new HashMap<String, ArrayList<String>>();


        // 1. 预处理给定的单词集合，将其统一处理为：<通用式，所有符合通用式单词的集合>
        wordList.forEach(
                word -> {
                    for(int i= 0 ; i<word.length(); i++){
                        String commonWord = word.substring(0,i) + "*" + word.substring(i+1, word.length()); // L
                        ArrayList<String> originWordsList = commonWords.getOrDefault(commonWord, new ArrayList<String>());
                        originWordsList.add(word);
                        commonWords.put(commonWord,originWordsList);
                    }
                }
        );


        // 0. 定义存放每次需要处理的单词的队列 & 已使用过的单词
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        List<String> usedWords = new ArrayList<>();

        // 初始化，将起始单词和level存入初始化变量
        queue.add(new Pair<>(beginWord, 1));


        // 2. 编写循环处理逻辑
        // 2.1 终止条件：队列为空
        while (!queue.isEmpty()){
            Pair<String, Integer> pop = ((LinkedList<Pair<String, Integer>>) queue).pop();
            String key = pop.getKey();
            Integer level = pop.getValue();

            // 2.2 循环获取当前队列的单词的每一通用式
            for(int i=0; i< key.length(); i++){
                String commonKey = key.substring(0,i) + "*" + key.substring(i+1, key.length());

                // 2.3 对每一个通用式，从预处理的通用式集合中找到所有的单词进行匹配
                for(String word : commonWords.getOrDefault(commonKey, new ArrayList<>())){
                    // 2.4 匹配成功则返回level,没匹配上则将没使用过的单词加入队列中
                    if(word.equals(endWord)){
                        return level + 1;
                    }
                    if(!usedWords.contains(word)){
                        usedWords.add(word);
                        queue.add(new Pair<>(word,level+1));
                    }
                }
            }
        }
        return 0;
    }



    public static void main(String[] args) {
        LeetCode_127_748_ladderLength ladderLength = new LeetCode_127_748_ladderLength();
        ArrayList<String> strings = new ArrayList<>();
        String[] ss = new String[]{"hot","dot","dog","lot","log","cog"};
        Collections.addAll(strings,ss);

        int i = ladderLength.ladderLength1("hit", "cog", strings);
        System.out.println(i);

    }


}
