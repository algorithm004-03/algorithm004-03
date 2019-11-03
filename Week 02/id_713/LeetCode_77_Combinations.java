package id_713;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class LeetCode_77_Combinations {
    /*
    参考: https://leetcode-cn.com/problems/combinations/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-ma-/
     */

    // 初始化结果集, 要不然就得作为 参数 参与递归
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        // 从 1 开始是题目的设定
        this.helper(n, k, 1, new Stack<>()); // 使用栈用于移除末尾元素, 比数组高效
        return res;
    }

    private void helper(int n, int k, int begin, Stack<Integer> pre) {
        // 够数了，就添加到结果集中
        if (pre.size() == k) {
            res.add(new ArrayList<>(pre));
            return;
        }

        // 关键在于分析出 i 的上界
        for (int i = begin; i <= n; i++) {
            pre.add(i);
            helper(n, k, i + 1, pre);
            pre.pop(); // 使用栈来解决最近一个元素的状态, 使用完就抛弃
        }
    }


}
