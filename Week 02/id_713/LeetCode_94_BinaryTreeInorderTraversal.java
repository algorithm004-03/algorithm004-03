package id_713;

import java.util.*;

/**
 * 94. 二叉树的中序遍历
 * 左根右
 */
public class LeetCode_94_BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        this.helper(list, root);

        return list;
    }

    public void helper(List<Integer> list, TreeNode root) {
        if (root == null) return;

        this.helper(list, root.left);
        list.add(root.val);
        this.helper(list, root.right);
    }


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}