package com.ning.test;

import java.util.LinkedList;
import java.util.List;

/**
 * 描述：
 *
 * @author shaoyu
 * @create 2019-11-02 下午1:36
 */
public class LeetCode_77_148 {
    List<List<Integer>> output = new LinkedList();
    int n;
    int k;

    public void backtrack(int first, LinkedList<Integer> curr) {
        if (curr.size() == k)
            output.add(new LinkedList(curr));

        for (int i = first; i < n + 1; ++i) {
            curr.add(i);
            backtrack(i + 1, curr);
            curr.removeLast();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backtrack(1, new LinkedList<Integer>());
        return output;
    }
}
