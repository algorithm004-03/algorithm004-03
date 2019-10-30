package id_693;

import java.util.*;

/**
 * @Desc 127. 单词接龙	https://leetcode-cn.com/problems/word-ladder/description/
 * @Auther 李雷(KyLin)
 * @Date 2019/10/30
 */
public class LeetCode_127_693 {

    //迭代bfs
    // 注意： char [] chars = each.toCharArray(); 这个必须每次变化的时候重新生成，引用对象
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        Set<String> reached = new HashSet<>();
        reached.add(beginWord);
        int distance = 1;
        while (!reached.contains(endWord)) {
            Set<String> temp = new HashSet<>();
            for (String each : reached) {
                for (int i = 0; i < each.length(); i++) {
                    char[] chars = each.toCharArray();
                    for (char j = 'a'; j <= 'z'; j++) {
                        chars[i] = j;
                        String word = new String(chars);
                        if (words.contains(word)) {
                            temp.add(word);
                            words.remove(word);
                        }
                    }
                }
            }
            distance++;
            if (temp.isEmpty()) {
                return 0;
            }
            reached = temp;
        }
        return distance;
    }

    /** 个人学习使用
     在提交里看到的最优解，看懂了，解读一下分享出来：
     需要掌握的知识递进：
     1.BFS。
     2.双端BFS。
     3.临近点查找方式：
     首先将所有的字符存到结构为HashSet的dic字典里去，然后将字符串的每一位挨个从a变到z,
     在变化的时候实时去字典里查，因为是hashset，所以复杂度是O(1)，非常快。
     如果查到了，则就是找到了临近点。
     */
    class Solution {
        //递归
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if (wordList == null || wordList.size() == 0) return 0;
            //hashset的好处：去重也完成了
            //开始端
            HashSet<String> start = new HashSet<>();
            //结束端
            HashSet<String> end = new HashSet<>();
            //所有字符串的字典
            HashSet<String> dic = new HashSet<>(wordList);
            start.add(beginWord);
            end.add(endWord);
            if (!dic.contains(endWord)) return 0;
            //经历过上面的一系列判定，到这里的时候，若是有路径，则最小是2，所以以2开始
            return bfs(start, end, dic, 2);

        }

        public int bfs(HashSet<String> st, HashSet<String> ed, HashSet<String> dic, int l) {
            //双端查找的时候，若是有任意一段出现了“断裂”，也就是说明不存在能够连上的路径，则直接返回0
            if (st.size() == 0) return 0;
            if (st.size() > ed.size()) {//双端查找，为了优化时间，永远用少的去找多的，比如开始的时候塞进了1000个，而结尾只有3个，则肯定是从少的那一端开始走比较好
                return bfs(ed, st, dic, l);
            }
            //BFS的标记行为，即使用过的不重复使用
            dic.removeAll(st);
            //收集下一层临近点
            HashSet<String> next = new HashSet<>();
            for (String s : st) {
                char[] arr = s.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char tmp = arr[i];
                    //变化
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (tmp == c) continue;
                        arr[i] = c;
                        String nstr = new String(arr);
                        if (dic.contains(nstr)) {
                            if (ed.contains(nstr)) return l;
                            else next.add(nstr);
                        }
                    }
                    //复原
                    arr[i] = tmp;
                }
            }
            return bfs(next, ed, dic, l + 1);
        }

    }
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    private static void test1() {

    }

    private static void test2() {
        System.out.println(new LeetCode_127_693().ladderLength(
                "hit",
                "cog",
                Arrays.asList(
                        "hot", "dot", "dog", "lot", "log"
                )) == 5);
    }

    private static void test3() {
        System.out.println(new LeetCode_127_693().ladderLength(
                "hit",
                "cog",
                Arrays.asList(
                        "hot", "dot", "dog", "lot", "log"
                )) == 0);
    }

    private static void test4() {
        System.out.println(new LeetCode_127_693().ladderLength(
                "hit",
                "cog",
                Arrays.asList(
                        "hot", "dot", "dog", "lot", "log", "cog"
                )) == 5);
    }

}
