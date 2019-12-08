package lesson_14;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode_127_633 {

    /**
     * 双向bfs 每次遍历节点少的队列(set) 可能是交换遍历
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> _wordList = new HashSet<>(wordList);
        if (!_wordList.contains(endWord)) {
            return 0;
        }
        Set<String> beginSet = new HashSet<>();
        Set<String>   endSet = new HashSet<>();
        int len = 1;
        int strLen = beginWord.length();
        HashSet<String> visited = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = new HashSet<>();
                set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            Set<String> temp = new HashSet<>();
            for (String word: beginSet) {
                char[] chs = word.toCharArray();
                for (int i = 0; i < chs.length; i++) {
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        char old = chs[i];
                        chs[i] = ch;
                        String target = String.valueOf(chs);
                        if (endSet.contains(target)) {
                            return len + 1;
                        }
                        if (!visited.contains(target) && _wordList.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        chs[i] = old;
                    }
                }
            }
            beginSet = temp;
            len++;
        }
        return 0;
    }

}