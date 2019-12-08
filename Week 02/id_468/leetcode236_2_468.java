package week2;

/**
 * @program: leetcode
 * @description: Lowest Common Ancestor of a Binary Tree
 * @author: 王瑞全
 * @create: 2019-10-2614:40
 **/


public class leetcode236_2_468 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         if(root==null||root==p||root==q){
             return root;
         }
         TreeNode left= lowestCommonAncestor(root.left,p,q);
         TreeNode right= lowestCommonAncestor(root.right,p,q);
         if(left!=null&&right!=null){
             return root;
         }
         return left==null?right:left;
    }

}
