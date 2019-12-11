import java.util.*;

public class LeetCode_127_368 {

    /*给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。
    转换需遵循如下规则：
    每次转换只能改变一个字母。
    转换过程中的中间单词必须是字典中的单词。
    说明:
    如果不存在这样的转换序列，返回 0。
    所有单词具有相同的长度。
    所有单词只由小写字母组成。
    字典中不存在重复的单词。
    你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
    链接：https://leetcode-cn.com/problems/word-ladder*/

    public static void main(String[] args) {

    }

    // BFS
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int depth = 0;
        Set<String> distSet = new HashSet<>(wordList);
        if (!wordList.contains(endWord)) {
            return depth;
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        visited.add(beginWord);
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return depth;
                }
                char[] chars = word.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char temp = chars[j];
                    for (char ch = 'a'; ch < 'z'; ch++) {
                        chars[j] = ch;
                        String str = new String(chars);
                        if (!distSet.contains(str) || visited.contains(str)) {
                            continue;
                        }
                        queue.add(str);
                        visited.add(str);
                    }
                    chars[j] = temp;
                }
            }
        }
        return 0;
    }

    // 双端BFS
    public int ladderLengthTwoBfs(String beginWord, String endWord, List<String> wordList) {
        int depth = 0;
        Set<String> distSet = new HashSet<>(wordList);
        if (!distSet.contains(endWord)) {
            return depth;
        }
        Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            depth++;
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            distSet.removeAll(beginSet);
            Set<String> tempSet = new HashSet<>();
            for (String word : beginSet) {
                char[] chars = word.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char temp = chars[j];
                    for (char ch = 'a'; ch < 'z'; ch++) {
                        chars[j] = ch;
                        String str = new String(chars);
                        if (!distSet.contains(str)) {
                            continue;
                        }
                        if (endSet.contains(str)) {
                            return depth+1;
                        }
                        tempSet.add(str);
                    }
                    chars[j] = temp;
                }
            }
            beginSet = tempSet;
        }
        return 0;
    }

    // 递归
    public int ladderLengthRecursion(String beginWord, String endWord, List<String> wordList) {
        int depth = 0;
        Set<String> distSet = new HashSet<>(wordList);
        if (!distSet.contains(endWord)) {
            return depth;
        }
        Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        return search(distSet, beginSet, endSet, 0);
    }

    public int search (Set<String> distSet, Set<String> beginSet, Set<String> endSet, int depth) {
        if (beginSet.isEmpty() || endSet.isEmpty()) {
            return 0;
        }
        depth++;
        distSet.removeAll(beginSet);
        Set<String> tempSet = new HashSet<>();
        for (String word : beginSet) {
            char[] chars = word.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                char temp = chars[j];
                for (char ch = 'a'; ch < 'z'; ch++) {
                    chars[j] = ch;
                    String str = new String(chars);
                    if (!distSet.contains(str)) {
                        continue;
                    }
                    if (endSet.contains(str)) {
                        return depth+1;
                    }
                    tempSet.add(str);
                }
                chars[j] = temp;
            }
        }
        return tempSet.size() > endSet.size() ? search(distSet, endSet, tempSet, depth) : search(distSet, tempSet, endSet, depth);
    }
}
