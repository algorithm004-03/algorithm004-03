
//leetcode 题号94 二叉树的中序遍历
import java.io.*;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import javax.swing.tree.TreeNode;

public class Solution {
    

    public List < Integer > inorderTraversal(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List < Integer > res) {
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