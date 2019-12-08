package problem127.Solution3;

import java.util.*;


/*
思路
A* 搜索查找嘴短距离
 */

public class Solution {

    private class State {
        String curStr;
        int stepNum;

        State(String str) {
            curStr = str;
            stepNum = 1;
        }

        State() {
            curStr = null;
            stepNum = 0;
        }
    }

    private int getDiffCharNum(String a, String b) {
        int cnt = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                cnt++;
            }
        }

        return cnt;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.length() != endWord.length()) {
            return 0;
        }

        HashMap<String, List<String>> link = new HashMap<>();

        boolean endWordExist = false;
        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.get(i).length() != beginWord.length()) {
                continue;
            }

            String si = wordList.get(i);
            if (si.equals(endWord)) {
                endWordExist = true;
            }

            for (int pos = 0; pos < si.length(); pos++) {
                StringBuilder builder = new StringBuilder(si);
                builder.setCharAt(pos, '?');
                List<String> l = link.getOrDefault(builder.toString(), new LinkedList<>());
                l.add(si);
                link.put(builder.toString(), l);
            }
        }

        if (!endWordExist) {
            return 0;
        }

        // 当前已经走的步数相同情况下，和目标相比变换次数少的优先出队
        PriorityQueue<State> pq = new PriorityQueue<>(new Comparator<State>() {
            @Override
            public int compare(State o1, State o2) {
                if (o1.stepNum != o2.stepNum) {
                    return o1.stepNum - o2.stepNum;
                }

                return getDiffCharNum(o1.curStr, endWord) - getDiffCharNum(o2.curStr, endWord);
            }
        });

        pq.add(new State(beginWord));
        State curState = null;
        Set<String> visitedStr = new HashSet<>();
        visitedStr.add(beginWord);

        while (!pq.isEmpty()) {
            curState = pq.poll();

            for (int pos = 0; pos < curState.curStr.length(); pos++) {
                StringBuilder builder = new StringBuilder(curState.curStr);
                builder.setCharAt(pos, '?');
                List<String> nextStep = link.get(builder.toString());
                if (nextStep == null) {
                    continue;
                }

                for (String s : nextStep) {
                    if (visitedStr.contains(s)) {
                        continue;
                    }

                    if (s.equals(endWord)) {
                        return curState.stepNum + 1;
                    }

                    State newState = new State();
                    newState.curStr = s;
                    newState.stepNum = curState.stepNum + 1;

                    visitedStr.add(newState.curStr);
                    pq.add(newState);
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        for (String s : new String[] { "hot","dot","dog","lot","log","cog"}) {
            list.add(s);
        }

        System.out.println(new Solution().ladderLength("hit", "cog", list));
    }
}

