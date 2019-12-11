import java.util.*;

public class LeetCode_126_368 {

    /*给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。
    转换需遵循如下规则：
    每次转换只能改变一个字母。
    转换过程中的中间单词必须是字典中的单词。
    说明:
    如果不存在这样的转换序列，返回一个空列表。
    所有单词具有相同的长度。
    所有单词只由小写字母组成。
    字典中不存在重复的单词。
    你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
    链接：https://leetcode-cn.com/problems/word-ladder-ii*/

    public static void main(String[] args) {

    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) {
            return res;
        }
        Set<String> visited = new HashSet<>();
        Queue<List<String>> queue = new LinkedList<>();
        queue.add(new ArrayList<>(Arrays.asList(beginWord)));
        visited.add(beginWord);
        boolean flag = false;
        while (!queue.isEmpty() && !flag) {
            int size = queue.size();
            Set<String> levels = new HashSet<>();
            for (int i = 0; i < size; i++) {
                List<String> path = queue.poll();
                String word = path.get(path.size() - 1);
                char[] chars = word.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char temp = chars[j];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[j] = ch;
                        String str = String.valueOf(chars);
                        if (words.contains(str) && !visited.contains(str)) {
                            List<String> list = new ArrayList<>(path);
                            list.add(str);
                            queue.add(list);
                            levels.add(str);
                            if (endWord.equals(str)) {
                                res.add(list);
                                flag = true;
                            }
                        }
                    }
                    chars[j] = temp;
                }
            }
            visited.addAll(levels);
        }
        return res;
    }

    public List<List<String>> findLadders02(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) {
            return res;
        }
        Map<String, List<String>> tree = new HashMap<>();
        Set<String> begin = new HashSet<>(), end = new HashSet<>();
        begin.add(beginWord);
        end.add(endWord);
        if (buildTree(words, tree, begin, end, true)) {
            dfs(res, tree, beginWord, endWord, new LinkedList<>());
        }
        return res;
    }

    private void dfs(List<List<String>> res, Map<String, List<String>> tree, String beginWord, String endWord, LinkedList<String> list) {
        list.add(beginWord);
        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<>(list));
            list.removeLast();
            return;
        }
        if (tree.containsKey(beginWord)) {
            for (String word : tree.get(beginWord)) {
                dfs(res, tree, word, endWord, list);
            }
        }
        list.removeLast();
    }

    private boolean buildTree(Set<String> words, Map<String, List<String>> tree, Set<String> begin, Set<String> end, boolean isFront) {
        if (begin.size() == 0) {
            return false;
        }
        if (begin.size() > end.size()) {
            return buildTree(words, tree, end, begin, !isFront);
        }
        words.removeAll(begin);
        boolean isMeet = false;
        Set<String> levels = new HashSet<>();
        for (String word : begin) {
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char temp = chars[i];
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    chars[i] = ch;
                    String str = String.valueOf(chars);
                    if (words.contains(str)) {
                        levels.add(str);
                        String key = isFront ? word : str;
                        String nextWord = isFront ? str : word;
                        if (!tree.containsKey(key)) {
                            tree.put(key, new ArrayList<>());
                        }
                        tree.get(key).add(nextWord);
                        if (end.contains(str)) {
                            isMeet =  true;
                        }
                    }
                }
                chars[i] = temp;
            }
        }
        if (isMeet) {
            return true;
        }
        return buildTree(words, tree, levels, end, isFront);
    }
}
