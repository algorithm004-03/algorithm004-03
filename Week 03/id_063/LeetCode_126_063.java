package problem126.Solution2;


/*

单纯使用BFS把所有最短路径全部找到的方法搜索空间太大了，其实可以想办法缩小搜索空间

假设最短距离是Len
BFS一次遍历可以找到所有距离起点距离小于等于Len的节点的从起点到该节点的最短距离
这个在BFS搜索到终点时候，可以全部算出了，而且这个计算量是不可能省掉的

有了这一堆信息，再次做路径搜索的时候就不要再用BFS了，因为BFS没法利用这个信息做减枝
但是DFS可以，DFS遍历到某一个节点时候，可以判断当前节点和终点距离，如果这个距离加上
前面算出来的起点到这个点的最短距离后，前面BFS算出来的最短距离要大，那这个节点不可能
再往下查找到最短距离了，也就是不可能产生最短路径，对应的分支就可马上剪掉，所以先BFS
再DFS， 这个是提升效率关键的思路
 */


import com.sun.tools.javadoc.SourcePositionImpl;
import com.sun.tools.javadoc.Start;

import java.util.*;

class Solution {

    private Map<String, Integer> strToMinlen;           // 起点到每一个点的最短距离
    private Map<String, List<String>> linkTable;        // 邻接表


    private void addSingleWordToLinkTable(String s) {
        for (int i = 0; i < s.length(); i++) {
            String newStr = s.substring(0, i) + "?" + s.substring(i+1, s.length());
            List<String> next = linkTable.getOrDefault(newStr, new LinkedList<>());

            next.add(s);
            linkTable.put(newStr, next);
        }
    }

    private void buildLinkTable(String beginWord, List<String> wordList) {
        linkTable = new HashMap<>();

        for (String s : wordList) {
            addSingleWordToLinkTable(s);
        }
        addSingleWordToLinkTable(beginWord);
    }

    private void getMinLenBfs(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        strToMinlen = new HashMap<>();

        int len = 0;
        queue.add(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            int nodeNum = queue.size();

            while ((nodeNum--) != 0) {
                String s = queue.poll();
                strToMinlen.put(s, len);        // 保存最短距离

                for (int i = 0; i < s.length(); i++) {
                    String newStr = s.substring(0, i) + "?" + s.substring(i + 1, s.length());
                    List<String> next = linkTable.getOrDefault(newStr, new LinkedList<>());

                    for (String nextStr : next) {
                        if (visited.contains(nextStr)) {
                            continue;
                        }

                        if (next.equals(endWord)) {
                            return;
                        }

                        visited.add(nextStr);
                        queue.add(nextStr);
                    }
                }
            }

            len++;
        }
    }

    private int getDiffNum(String a, String b) {
        int cnt = 0;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                cnt++;
            }
        }

        return cnt;
    }

    private void dfs(String cur, String target, List<String> path, Set<String> visited, List<List<String>> result, int targetMinLen) {
        //System.out.println(path);

        if (cur.equals(target)) {
            //System.err.println(path);

            result.add(new LinkedList<>(path));
            path.remove(path.size() - 1);
            visited.remove(cur);

            return;
        }

        if (strToMinlen.get(cur) + getDiffNum(cur, target) > targetMinLen) {
            path.remove(path.size() - 1);
            visited.remove(cur);
            return;
        }

        // strToMinlen中找所有可能到的下一个节点，不在这个表里面的节点最后不可能通过最短路径到终点
        for (int i = 0; i < cur.length(); i++) {
            String newStr = cur.substring(0, i) + "?" + cur.substring(i+1, cur.length());
            List<String> next = linkTable.getOrDefault(newStr, new LinkedList<>());

            for (String s : next) {
                if (!strToMinlen.containsKey(s)) {
                    continue;
                }

                if (visited.contains(s)) {
                    continue;
                }

                // 只允许通过最短的路到下一个节点，进行减枝
                if (path.size() > strToMinlen.get(s)) {
                    continue;
                }

                visited.add(s);
                path.add(s);
                dfs(s, target, path, visited, result, targetMinLen);
            }
        }

        path.remove(path.size() - 1);
        visited.remove(cur);
    }

    private void getMinPathDfs(String start, String target, List<List<String>> result) {
        if (!strToMinlen.containsKey(target)) {
            return;
        }

        List<String> path = new LinkedList<>();
        Set<String> visited = new HashSet<String>();

        path.add(start);
        visited.add(start);

        dfs(start, target, path, visited, result, strToMinlen.get(target));
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        buildLinkTable(beginWord, wordList);
        getMinLenBfs(beginWord, endWord, wordList);

        List<List<String>> result = new LinkedList<>();
        getMinPathDfs(beginWord, endWord, result);

        return result;
    }

    public static void main(String[] args) {
        new Solution().findLadders("hit", "cog", Arrays.asList("hot","dot","dog","lot","log"));
    }
}
