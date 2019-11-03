package test1.week_2;

import test1.Week2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/10/27.
 */
public class Leetcode_94_638 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 二叉树中序遍历
     * @param root
     * @return
     */
    public static List< Integer > inorderTraversal(TreeNode root) {
        List< Integer > list = new ArrayList<Integer>();
        helper(root,list);
        return list;
    }

    public static void helper(TreeNode root, List<Integer> list){
        if(root != null){
            if(root.left != null){
                helper(root.left,list);
            }
            list.add(root.val);
            if(root.right != null){
                helper(root.right,list);
            }
        }

    }
}
