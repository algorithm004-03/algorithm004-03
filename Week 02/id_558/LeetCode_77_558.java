package Week02;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @Date 2019/10/27.
 * @see <a href="77">https://leetcode-cn.com/problems/combinations/</a>
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */

public class LeetCode_77_558 {
    /**
     * 核心：确定终止条件（terminator）
     */
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        traversal(lists, list, n, k, 1);
        return lists;
    }

    private static void traversal(List<List<Integer>> lists, List<Integer> list, int n, int k, int position) {
        //terminator
        if (list.size() == k) {
            lists.add(new ArrayList<Integer>(list));
            return;
        }
        //process logic
        for (int i = position; i <= n; i++) {
            list.add(i);
            //drill down
            traversal(lists, list, n, k, i + 1);
            //reset state
            list.remove(new Integer(i));
        }
    }


    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }
}