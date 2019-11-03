package no144;

import base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author boyiren
 * @date 2019-10-27
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        helper(root.left, res);
        helper(root.right, res);
    }
}
