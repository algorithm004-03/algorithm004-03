package com.test.leetcode.week02;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class SolutionCombine77 {


    @Test
    public void test1() {
        System.out.println(combine(4, 2));
    }

    /**
     * 返回1 - n 中所有可能的k个数的组合
     * @param n
     * @param k
     * @return
     */
    List<List<Integer>> output = new LinkedList<>();
    int n;
    int k;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backtrace(1, new LinkedList<Integer>());
        return output;
    }

    private void backtrace(int first, LinkedList<Integer> cur) {
        // 递归终止条件
        if (cur.size() == k) {
            output.add(new LinkedList<>(cur));
            return;
        }
        // 处理当前层
        for (int i = first; i < n + 1; i ++) {
            cur.add(i);
            // 处理下一层
            backtrace(i + 1, cur);
            // 清理当前层
            cur.removeLast();

        }
    }
}
