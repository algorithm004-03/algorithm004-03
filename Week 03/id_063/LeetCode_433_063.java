/*
BFS 对最短了路径长度进行查找
 */


import java.util.*;

class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Map<String, List<String>> linkTable = new HashMap<>();

        // 生成邻接表
        for (String s : bank) {
            for (int i = 0; i < s.length(); i++) {
                String newStr = s.substring(0, i) + "?" + s.substring(i+1, s.length());
                List<String> next = linkTable.getOrDefault(newStr, new LinkedList<>());
                next.add(s);
                linkTable.put(newStr, next);
            }
        }

        int length = 1;
        boolean findTarget = false;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int nodeNum = queue.size();     // 当前层的节点个数

            while ((nodeNum--) != 0) {
                String curStr = queue.poll();

                for (int i = 0; i < curStr.length(); i++) {
                    String newStr = curStr.substring(0, i) + "?" + curStr.substring(i + 1, curStr.length());
                    List<String> next = linkTable.getOrDefault(newStr, new LinkedList<>());

                    for (String s : next) {
                        if (visited.contains(s)) {
                            continue;
                        }

                        if (s.equals(end)) {
                            findTarget = true;
                            return length;
                        }

                        queue.add(s);
                        visited.add(s);
                    }
                }
            }

            length++;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minMutation("AACCGGTT", "AAACGGTA", new String[] {"AACCGGTA", "AACCGCTA", "AAACGGTA"}));
    }
}