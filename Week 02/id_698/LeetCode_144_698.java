import java.util.LinkedList;

/**
 * 给定一个二叉树，返回它的 前序 遍历。
 * @author gning (id=698)
 * 
 */

 public class LeetCode_144_698 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
           val = x;
        }
     }
     /**
      * 默写官方题解
      */

      public List<Integer> preorderTraversal(TreeNode root) {
          LinkedList<TreeNode> stack = new LinkedList();
          LinkedList<Integer> output = new LinkedList();

          if(root==null) {
              return output;
          }

          stack.add(root);

          while(!stack.isEmpty()) {
              TreeNode node = stack.pollLast();
              output.add(node.val );
              if(node.right!=null) {
                  stack.add(node.right);
              }

              if(node.left!=null) {
                  stack.add(node.left);
              }
          }
          return output;
      }
 }