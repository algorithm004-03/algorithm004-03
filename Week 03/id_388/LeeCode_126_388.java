package com.company.leetcode.editor.cn;//给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
//
//
// 每次转换只能改变一个字母。
// 转换过程中的中间单词必须是字典中的单词。
//
//
// 说明:
//
//
// 如果不存在这样的转换序列，返回一个空列表。
// 所有单词具有相同的长度。
// 所有单词只由小写字母组成。
// 字典中不存在重复的单词。
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
//
//
// 示例 1:
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出:
//[
//  ["hit","hot","dot","dog","cog"],
//  ["hit","hot","lot","log","cog"]
//]
//
//
// 示例 2:
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: []
//
//解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
// Related Topics 广度优先搜索 数组 字符串 回溯算法


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if (beginWord.equals(endWord)) {
            return res;
        }
        HashSet<String> wordDict = new HashSet<>(wordList);
        if (!wordDict.contains(endWord)) {
            return res;
        }
        Map<String,List<String>> nodeNeighbors = new HashMap<>();
        wordDict.add(beginWord);
        for (String str:wordDict) {
            nodeNeighbors.put(str,new ArrayList<>());
            wordDict.add(str);
        }

        Map<String,Integer> distanceMap = new HashMap<>();

        bfs(beginWord,endWord,wordDict,nodeNeighbors,distanceMap);

        List<String> solution = new ArrayList<>();
        dfs(beginWord,endWord,nodeNeighbors,res,solution,distanceMap);

        return res;

    }

    private void dfs(String beginWord, String endWord, Map<String,List<String>> nodeNeighbors, List<List<String>> res, List<String> solution,Map<String,Integer> distanceMap) {
        solution.add(beginWord);
        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<>(solution));
        } else {
            for (String next:nodeNeighbors.get(beginWord)) {
                if (distanceMap.get(next) == distanceMap.get(beginWord) + 1) {
                    dfs(next,endWord,nodeNeighbors,res,solution,distanceMap);
                }
            }
        }
        solution.remove(solution.size() - 1);
    }

    private void bfs(String beginWord, String endWord, HashSet<String> wordDict,
                     Map<String, List<String>> nodeNeighbors, Map<String, Integer> distanceMap) {
        Queue<String> queue = new LinkedList();
        queue.add(beginWord);
        distanceMap.put(beginWord,0);
        int shortestDistance = Integer.MAX_VALUE;

        while (!queue.isEmpty()) { //level by level

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                int currDistance = distanceMap.get(curr);
                if (currDistance > shortestDistance) {
                    return;
                }
                List<String> neighbors = getNeighbors(wordDict,curr);
                for (String neighbor:neighbors) {
                    nodeNeighbors.get(curr).add(neighbor);

                    if (distanceMap.containsKey(neighbor)) {
                        continue;
                    }
                    distanceMap.put(neighbor,currDistance + 1);
                    if (neighbor.equals(endWord)) {
                        shortestDistance = currDistance + 1;
                    } else {
                        queue.offer(neighbor);
                    }
                }
            }

        }

    }

    private List<String> getNeighbors(HashSet<String> wordDict, String curr) {

        List<String> res = new ArrayList<>();
        char[] chs = curr.toCharArray();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i <chs.length; i++) {

                char old = chs[i];
                chs[i] = c;
                if (wordDict.contains(String.valueOf(chs))) {
                    res.add(String.valueOf(chs));
                }
                chs[i] = old;
            }
        }

        return res;

    }


//    public static void main(String[] args) {
//        Solution s = new Solution();
//        String beginWord = "hit";
//        String  endWord = "cog";
//        List<String> wordList = Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"});
//
//        List<List<String>> res = s.findLadders(beginWord,endWord,wordList);
//        System.out.println(res.toString());
//
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
