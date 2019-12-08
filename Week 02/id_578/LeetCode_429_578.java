package com.hand.week2;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @version: 1.0
 * @author: xiantao.han@hand-china.com
 * @Date: 2019/10/27
 */
public class LeetCode_429_578 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(Node root) {
        helper(root, 0);
        return result;
    }

    private void helper(Node root, int depth) {
        if (root == null) return;
        if (depth >= result.size()) result.add(new ArrayList<>());
        result.get(depth).add(root.val);
        for (int i = 0; i < root.children.size(); ++i) {
            helper(root.children.get(i), depth + 1);
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
