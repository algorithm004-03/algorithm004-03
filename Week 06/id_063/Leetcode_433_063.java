/*
双向A* 解法
 */


import java.util.*;

class Solution {

    private int strDiff(String s1, String s2) {
        int minLen = Math.min(s1.length(), s2.length());

        int cnt = 0;
        for (int i = 0; i < minLen; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                cnt++;
            }
        }

        return cnt;
    }

    private class Node implements Comparable {
        String curStr;
        int steps;
        String targetStr;

        public Node(String curStr, int steps, String targetStr) {
            this.curStr = curStr;
            this.steps = steps;
            this.targetStr = targetStr;
        }

        @Override
        public int compareTo(Object o) {
            Node node = (Node)o;
            return ((steps + strDiff(curStr, targetStr)) - (node.steps + strDiff(node.curStr, node.targetStr)));
        }
    }


    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankString = new HashSet<>(Arrays.asList(bank));

        if (!bankString.contains(end)) {
            return -1;
        }

        Set<String> visited = new HashSet<>();

        final String startTargetStr = end;
        final String endTargetStr = start;

        PriorityQueue<Node> startHeap = new PriorityQueue<>();
        Set<String> startSet = new HashSet<>();
        PriorityQueue<Node> endHeap = new PriorityQueue<>();
        Set<String> endSet = new HashSet<>();


        startHeap.add(new Node(start, 0, startTargetStr));
        startSet.add(start);
        endHeap.add(new Node(end, 0, endTargetStr));
        endSet.add(end);
        visited.add(start);
        visited.add(end);

        int len = 0;
        while ((startHeap.size() != 0) && (endHeap.size() != 0)) {
            PriorityQueue<Node> expandHeap = null;
            Set<String> expandSet = null;
            Set<String> targetSet = null;

            if (startHeap.size() < endHeap.size()) {
                expandHeap = startHeap;
                expandSet = startSet;

                targetSet = endSet;
            } else {
                expandHeap = endHeap;
                expandSet = endSet;

                targetSet = startSet;
            }

            // 数值更少的一端进行状态拓展
            Node node = expandHeap.poll();
            String curStr = node.curStr;
            expandSet.remove(curStr);

            char[] charArr = curStr.toCharArray();
            for (int i = 0; i < curStr.length(); i++) {
                char oldChar = charArr[i];

                for (char ch : new char[] {'A', 'C', 'G', 'T'}) {
                    if (ch == oldChar) {
                        continue;
                    }

                    charArr[i] = ch;
                    String s = new String(charArr);

                    if (targetSet.contains(s)) {
                        return len + 1;
                    }

                    if (!bankString.contains(s)) {
                        continue;
                    }

                    if (visited.contains(s)) {
                        continue;
                    }

                    expandHeap.add(new Node(s, node.steps+1, node.targetStr));
                    expandSet.add(s);
                    visited.add(s);
                }

                charArr[i] = oldChar;
            }

            len++;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minMutation("AAAAACCC", "AACCCCCC", new String[] {"AAAACCCC", "AAACCCCC", "AACCCCCC"}));
    }
}