package com.hand.week2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description:
 * @version: 1.0
 * @author: xiantao.han@hand-china.com
 * @Date: 2019/10/27
 */
public class LeetCode_77_578 {
    List<List<Integer>> result = new ArrayList<>();

    //n个数 k个格子
    public List<List<Integer>> combine(int n, int k) {
        helper(1, n, k, new Stack<>());
        return result;
    }

    private void helper(int depth, int n, int k, Stack<Integer> stack) {
        if (stack.size() == k) {
            result.add(new ArrayList<>(stack));
            return;
        }
        for (int i = depth; i <= n; ++i) {
            stack.push(i);
            helper(i + 1, n, k, stack);
            stack.pop();
        }
    }
}
