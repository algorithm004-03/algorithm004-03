package com.homework.week3;

import java.util.*;

public class LeeCode_126_103 {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Queue<String> queue = new java.util.concurrent.LinkedBlockingQueue<>();
        Map<String, Integer> dis = new HashMap<>();
        Map<String, List<String>> relation = new HashMap<>();

        dis.put(beginWord, 0);
        queue.add(beginWord);
        while (!queue.isEmpty()) {
            // 获取未访问节点中，路径最短的节点，所有边的权重为1
            String str = queue.poll();
            int minPath = dis.get(str);

            // 更新与未访问节点中路径最短节点相邻节点的最短路径，同时记录节点的最短路径前一节点
            for (String key : wordList) {
                // 判断两个节点是否相邻
                int k = 0;
                for (int i = 0; i < key.length(); i++) {
                    if (str.charAt(i) != key.charAt(i)) {
                        k++;
                    }
                    if (1 < k) {
                        break;
                    }
                }
                // 相邻节点，更新最短路径，同时记录节点的最短路径前一节点
                if (1 == k) {
                    if (null == relation.get(key) || null == dis.get(key) || minPath + 1 < dis.get(key)) {
                        List<String> re = new ArrayList<>();
                        re.add(str);
                        relation.put(key, re);
                    } else {
                        if (minPath + 1 == dis.get(key)) {
                            relation.get(key).add(str);
                        }
                    }
                    if (!dis.containsKey(key)) {
                        queue.add(key);
                    }
                    dis.put(key, Math.min(minPath + 1, null == dis.get(key) ? Integer.MAX_VALUE : dis.get(key)));
                }
            }

            // 剔除已访问过节点
            dis.remove(str);
            wordList.remove(str);
        }

        List<List<String>> res = new LinkedList<>();
        LinkedList<String> tmp = new LinkedList<>();
        tmp.addFirst(endWord);
        dfs(endWord, tmp, relation, res, beginWord);

        return res;
    }

    private void dfs(String cur, LinkedList<String> tmp, Map<String, List<String>> relation, List<List<String>> res, String beginWord) {
        if (cur.equals(beginWord)) {
            res.add(new LinkedList<>(tmp));
            return;
        }
        if (!relation.containsKey(cur)) {
            return;
        }

        List<String> pre = relation.get(cur);
        for (int i = 0; i < pre.size(); i++) {
            cur = pre.get(i);
            tmp.addFirst(cur);
            dfs(cur, tmp, relation, res, beginWord);
            tmp.removeFirst();
        }
    }
}
