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
        recursionConvenience(root,list);
        return list;
    }

    public void recursionConvenience(TreeNode root,List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            if (root.left != null) {
                recursionConvenience(root.left,list);
            }
            if (root.right != null) {
                recursionConvenience(root.right,list);
            }
        }
    }

    //迭代，后补

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        iterativeConvenience(root,list);
        return list;
    }

    public void iterativeConvenience(TreeNode root,List<Integer> list) {
        while (root != null) {
            list.add(root.val);
            while (root.left != null) {
                list.add(root.left.val);
            }
            while (root.right != null) {
                list.add(root.right.val);
            }
        }
    }
}
