package test1.week_2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/10/27.
 */
public class Leetcode_144_638 {
    public static class TreeNode {
        int val;
       TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 二叉树前序遍历
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List< Integer > list = new ArrayList<Integer>();
        helperPre(root,list);
        return list;
    }

    public  void helperPre(TreeNode root,List<Integer> list){
        if(root != null){
            list.add(root.val);
            // if(root.left != null)
            helperPre(root.left,list);
            // if(root.right != null){
            helperPre(root.right,list);
            // }
        }
    }
}
