package id_693;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc 94. 二叉树的中序遍历    https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * @Auther 李雷(KyLin)
 * @Date 2019/10/22
 */
public class LeetCode_94_693 {

    //递归
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        heper(root, list);
        return list;
    }

    public void heper(TreeNode root, List<Integer> list) {
        if (root != null) {
            if (root.left != null) {
                heper(root.left, list);
            }
            list.add(root.val);
            if (root.right != null) {
                heper(root.right, list);
            }
        }
    }

    //迭代，后补
}
