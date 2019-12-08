package com.leetcode.week02;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tim on 2019/10/27.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Node node = solution.generateNode(3);
        solution.levelOrder(node);
    }

    private Node generateNode(int depth) {
        if (depth <= 0) {
            return null;
        }
        Node node = new Node();
        node.val =depth -1;
        node = generateNode(depth - 1);
        return node;
    }

    //https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
    // 429. N叉树的层序遍历
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        //判断条件
        if (root == null) {
            return null;
        }

        //  本层逻辑
        helper(root, 0, res);
        return res;
        //drill down
        //clear state
    }

    private void helper(Node root, int depth, List<List<Integer>> res) {
        if (root == null) return;
        //判断是否是新的一层
        if (depth + 1 > res.size()) {
            res.add(new ArrayList<Integer>());
        }
        res.get(depth).add(root.val);

        //处理子节点
        for (Node node : root.children) {
            if (node != null) {
                helper(node, depth + 1, res);
            }
        }
    }





}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}