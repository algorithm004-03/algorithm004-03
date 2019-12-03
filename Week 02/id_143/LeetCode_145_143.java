/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root !=null ){
            result = getSon(root,result);
        }

        return result;
    }

    public List<Integer> getSon(TreeNode currentNode,List result){
        if(currentNode.left == null && currentNode.right == null){
            result.add(currentNode.val);
            return result;
        }

        if(currentNode.left != null){
            result = getSon(currentNode.left, result);
        }
        if(currentNode.right != null){
            result = getSon(currentNode.right, result);
        }
        result.add(currentNode.val);
        return result;

    }
}
// @lc code=end
//  比较难想到,或者说陷入 前序与中序的套路里了。
    //主要思路: 宽度优先,然后逆序输出
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<Integer>();

        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        while( !stack.isEmpty() ){

            TreeNode current = stack.pollLast();
            result.addFirst(current.val);

            if(current.left != null){
                stack.add(current.left);
            }
            if(current.right != null){
                stack.add(current.right);
            }
        }
        return result;
    }