package week3;

import java.util.*;

/**
 * @program: leetcode
 * @description: Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:
 * @author: 王瑞全
 * @create: 2019-11-0314:31
 **/


public class leetcode126_3_468 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dict = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        HashMap<String, ArrayList<String>> nodeNeighbors = new HashMap<>();
        HashMap<String, Integer> distance = new HashMap<>();
        ArrayList<String> solution = new ArrayList<>();
        dict.add(beginWord);
        bfs(beginWord, endWord, dict, nodeNeighbors, distance);
        dfs(beginWord,endWord,dict,nodeNeighbors,distance,solution,res);
        return res;
    }

    //bfs:跟踪每个节点到其实节点的距离
    private void bfs(String start, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance) {
        for (String str : dict) {
            nodeNeighbors.put(str, new ArrayList<>());
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        distance.put(start, 0);
        while (!queue.isEmpty()) {
            int count = queue.size();
            boolean found = false;
            for (int i = 0; i < count; i++) {
                String cur = queue.poll();
                int curDistance = distance.get(cur);
                ArrayList<String> neughbors = getNeightbors(cur, dict);

                for (String neighbor : neughbors) {
                    nodeNeighbors.get(cur).add(neighbor);
                    if (!distance.containsKey(neighbor)) {
                        distance.put(neighbor, curDistance + 1);
                        if (end.equals(neighbor)) {
                            found = true;
                        } else {
                            queue.offer(neighbor);
                        }
                    }
                }
            }
            if (found) {
                break;
            }
        }

    }

    //找到所有的下一层节点
    private ArrayList<String> getNeightbors(String node, Set<String> dict) {
        ArrayList<String> res = new ArrayList<>();
        char[] chs = node.toCharArray();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == ch) continue;
                char old_ch = chs[i];
                chs[i] = ch;
                if (dict.contains(String.valueOf(chs))) {
                    res.add(String.valueOf(chs));
                }
                chs[i] = old_ch;
            }
        }
        return res;
    }


    //DFS : 输出所有path的最短路径
    private void dfs(String cur,String end,Set<String> dict,HashMap<String,ArrayList<String>> nodeNeighbors,HashMap<String,Integer> distance,ArrayList<String> solution,List<List<String>> res){
        solution.add(cur);
        if(end.equals(cur)){
            res.add(new ArrayList<>(solution));
        }else{
            for(String next:nodeNeighbors.get(cur)){
                if(distance.get(next)==distance.get(cur)+1){
                    dfs(next,end,dict,nodeNeighbors,distance,solution,res);
                }
            }
        }
        solution.remove(solution.size()-1);

    }

}
