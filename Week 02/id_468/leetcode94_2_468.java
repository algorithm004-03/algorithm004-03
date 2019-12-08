package week2;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: Binary Tree Inorder Traversal
 * @author: 王瑞全
 * @create: 2019-10-2219:50
 **/


public class leetcode94_2_468 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
         if(root==null){
             return null;
         }
         List<Integer> list=new ArrayList<>();
         helper(root,list);
         return list;
    }
    public List<Integer> helper(TreeNode root,List<Integer> list){
        if(root!=null) {
            helper(root.left, list);
            list.add(root.val);
            helper(root.right, list);
        }
        return list;
    }
}
