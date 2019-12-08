import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=127 lang=java
 *
 * [127] 单词接龙
 *
 * 在bfs模板后,调试了各种办法,不是超时,就是边界条件有问题。一直没忍着看题解,总是觉得快Get the point,结果花费许久时间。
 * 排名很是落后。。
 *
 */

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
        Map<String,Integer> visiedLevel = new HashMap<String,Integer>();
        LinkedList<String> deque  = new LinkedList<String>();
        deque.offerLast(beginWord);
        visiedLevel.put(beginWord,1);
        //用deque实现按层遍历BFS
        while(!deque.isEmpty()) {
            String cs = deque.pollFirst();
            int csl_min = visiedLevel.get(cs);
            if (cs.equals(endWord)) {
                return visiedLevel.get(cs);
            }

            for (int i = 0; i < wordList.size(); i++) {
                if (near(cs, wordList.get(i))) {
                    if (!visiedLevel.containsKey(wordList.get(i))) {
                        deque.offerLast(wordList.get(i));
                        visiedLevel.put(wordList.get(i), csl_min + 1);
                    } else {
                        if (visiedLevel.get(wordList.get(i)) > (csl_min + 1)) {
                            visiedLevel.put(wordList.get(i), csl_min + 1);
                        }
                    }
                }
            }
        }
        return 0;
    }
//判断两个单词是否相近,即相差为1
    public boolean near(String a,String b){
        int c = 0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i) != b.charAt(i)){
                c++;
            }
        }
        return c == 1 ;
    }
}
// @lc code=end

