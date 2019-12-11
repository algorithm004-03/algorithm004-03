import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Solution {


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        
        Set<String> visited = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        int len = 1;

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
            }

            Set<String> next = new HashSet<>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();
                for (int i = 0; i < chs.length; ++i) {
                    for (char ch = 'a'; ch <= 'z'; ++ch) {
                        char old = chs[i];
                        chs[i] = ch;
                        String cur = new String(chs);
                        if (endSet.contains(cur)) {
                            return len + 1;
                        }
                        if (!visited.contains(cur) && wordSet.contains(cur)) {
                            next.add(cur);
                            visited.add(cur);
                        }
                        chs[i] = old;
                    }
                }
            }
            beginSet = next;
            len++;
        }
        return 0;
    }


    public int ladderLengthBFS(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        visited.add(beginWord);
        queue.offer(beginWord);
        int len = 0;
        
        while (!queue.isEmpty()) {
            len++;
            int size = queue.size();
            while (size-- > 0) {
                String cur = queue.poll();
                for (String word : wordList) {
                    if (visited.contains(word)) {
                        continue;
                    }
                    if (!canTransfer(cur, word)) {
                        continue;
                    }
                    if (endWord.equals(word)) {
                        return len + 1;
                    }
                    queue.add(word);
                    visited.add(cur);
                }
            }
        }
        return 0;
    }

    private boolean canTransfer(String s1, String s2) {
        int i = 0;
        int count = 0;
        while (i < s1.length()) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
            i++;
        }
        return count == 1;
    }
}