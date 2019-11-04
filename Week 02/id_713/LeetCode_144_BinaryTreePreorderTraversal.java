package id_713;

import java.util.ArrayList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 * 根左右
 */
public class LeetCode_144_BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        this.helper(list, root);

        return list;
    }

    public void helper(List<Integer> list, TreeNode root) {
        if (root == null) return;

        list.add(root.val);
        this.helper(list, root.left);
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
