package com.company.leetcode.editor.cn;
//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
//
//
// 每次转换只能改变一个字母。
// 转换过程中的中间单词必须是字典中的单词。
//
//
// 说明:
//
//
// 如果不存在这样的转换序列，返回 0。
// 所有单词具有相同的长度。
// 所有单词只由小写字母组成。
// 字典中不存在重复的单词。
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
//
//
// 示例 1:
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
//
//
// 示例 2:
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。
// Related Topics 广度优先搜索


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (beginWord.equals(endWord)) {
            return 0;
        }
        LinkedList<String> queue = new LinkedList();

        //计算每一层的字母
        Set<Character> charSet = new HashSet<>();
        Set<String> wordSet = new HashSet<>();

        for (int i = 0; i < wordList.size(); i++) {
            char[] tmp = wordList.get(i).toCharArray();
            wordSet.add(wordList.get(i));
            for (int j = 0; j < tmp.length; j++) {
                if (!charSet.contains(tmp[j])) {
                    charSet.add(tmp[j]);
                }
            }
        }
        List<Character> charList = new ArrayList(charSet);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        queue.addFirst(beginWord);
        Set<String> visited = new HashSet<>();


        int level = 0;
        int charIndex = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size > 0) {
                String curr = queue.pollFirst();
                size--;
                if (curr.equals(endWord)){
                    return level + 1;
                }

                char[] old = curr.toCharArray();

                for (int i = 0; i < charList.size(); i++) {
                    for (int j = 0; j < old.length; j++) {
                        old[j] = charList.get(i);
                        String tmp = new String(old);
                        if (!visited.contains(tmp) && wordSet.contains(tmp)){
                            visited.add(tmp);
                            queue.addLast(tmp);
                        }
                        old[j] = curr.charAt(j);
                    }
                }
            }

            level++;
        }
        return 0;

    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        String beginWord = "hit";
//        String endWord = "cog";
//        String[] wordList = new String[]{"hot","dot","dog","lot","log","cog"};
//        int res = s.ladderLength(beginWord,endWord,Arrays.asList(wordList));
//        System.out.println(res);
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
