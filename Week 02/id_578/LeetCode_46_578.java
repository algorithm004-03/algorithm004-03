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
public class LeetCode_46_578 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        int[] visited = new int[nums.length];
        helper(0, visited, nums, new Stack<Integer>());
        return result;
    }

    private void helper(int depth, int[] visited, int[] nums, Stack<Integer> stack) {
        if (depth == nums.length) {
            result.add(new ArrayList<Integer>(stack));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (visited[i] == 1) continue;
            stack.push(nums[i]);
            visited[i] = 1;
            helper(depth + 1, visited, nums, stack);
            stack.pop();
            visited[i] = 0;
        }
    }
}
