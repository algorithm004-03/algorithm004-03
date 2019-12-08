package week2;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: 二叉树的前序遍历
 * @author: 王瑞全
 * @create: 2019-10-2220:44
 **/


public class leetcode144_2_468 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    public List<Integer> helper(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            helper(root.left, list);
            helper(root.right, list);
        }
        return list;
    }
}

