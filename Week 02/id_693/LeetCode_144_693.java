package id_693;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc 144. 二叉树的前序遍历  https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * @Auther 李雷(KyLin)
 * @Date 2019/10/22
 */
public class LeetCode_144_693 {

    //递归
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        front(root, list);
        return list;
    }

    public void front(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            if (root.left != null) {
                front(root.left, list);
            }
            if (root.right != null) {
                front(root.right, list);
            }
        }
    }

    //迭代，后补
}
