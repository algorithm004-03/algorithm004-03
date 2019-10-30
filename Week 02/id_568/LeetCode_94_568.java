package com.leetcode.kelvin;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kelvin
 * @date 2019/10/27 11:00 PM
 */
public class LeetCode_94_568 {
    public List<Integer> inoorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
