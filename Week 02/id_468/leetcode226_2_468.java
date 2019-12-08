package week2;

/**
 * @program: leetcode
 * @description: Invert Binary Tree
 * @author: 王瑞全
 * @create: 2019-10-2518:25
 **/


public class leetcode226_2_468 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode invertTree(TreeNode root) {
      if(root==null){
          return root;
      }
      TreeNode temp=root.right;
      root.right=root.left;
      root.left=temp;
      if(root.left!=null) {
          invertTree(root.left);
      }
      if(root.right!=null) {
          invertTree(root.right);
      }
      return root;

    }
}
