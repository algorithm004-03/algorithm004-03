/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
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
 * 经典递归算法
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null){
            return result;
        }

        result = getSon(root,result);
        return result;
    }

    public List<Integer> getSon(TreeNode currentNode,List<Integer> result){
        if(currentNode.left == null && currentNode.right == null){
            result.add(currentNode.val);
            return result;
        }
        if(currentNode.left !=null){
            result = getSon(currentNode.left,result);
        }
        result.add(currentNode.val);
        if(currentNode.right != null ){
            result = getSon(currentNode.right, result);
        }
        return result;
    }

}
// @lc code=end
//尝试加深理解基于栈的算法

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();


        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while((!stack.isEmpty()) || (current != null)){
            while(current != null){
                stack.push(current);
                current  = current.left;
            }
            current = stack.pop();
            result.add(current.val);
            current = current.right;

        }
        return result;
    }



}
