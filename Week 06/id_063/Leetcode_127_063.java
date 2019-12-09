/*
双向BFS实现
 */

import java.util.*;

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
                String newStr = si.substring(0, pos) + "?" + si.substring(pos+1, si.length());
                List<String> l = link.getOrDefault(newStr, new LinkedList<>());
                l.add(si);
                link.put(newStr, l);
            }
        }

        if (!endWordExist) {
            return 0;
        }


        Set<String> startSta = new HashSet<>();
        startSta.add(beginWord);
        Set<String> endSta = new HashSet<>();
        endSta.add(endWord);

        Set<String> visitedStr = new HashSet<>();
        visitedStr.add(beginWord);
        visitedStr.add(endWord);

        int len = 1;
        while (!startSta.isEmpty() && !endSta.isEmpty()) {
            if (startSta.size() > endSta.size()) {
                Set<String> sta = startSta; startSta = endSta; endSta = sta;
            }

            Set<String> newSta = new HashSet<>();
            for (String curStr : startSta) {
                for (int pos = 0; pos < curStr.length(); pos++) {
                    String newStr = curStr.substring(0, pos) + "?" + curStr.substring(pos+1, curStr.length());
                    List<String> nextStep = link.get(newStr);
                    if (nextStep == null) {
                        continue;
                    }

                    for (String s : nextStep) {
                        if (endSta.contains(s)) {
                            return len + 1;
                        }

                        if (visitedStr.contains(s)) {
                            continue;
                        }
                        visitedStr.add(s);

                        newSta.add(s);
                    }
                }
            }

            startSta = newSta;
            len++;
        }

        return 0;
    }

    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        for (String s : new String[] {"hot","dot","dog","lot","log","cog"}) {
            list.add(s);
        }

        System.out.println(new Solution().ladderLength("hit", "cog", list));
    }
}