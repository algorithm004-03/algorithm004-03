/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
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
    public List<Integer> preorderTraversal(TreeNode root) {
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
        result.add(currentNode.val);
        if(currentNode.left != null){
            result = getSon(currentNode.left, result);
        }
        if(currentNode.right != null){
            result = getSon(currentNode.right, result);
        }
        return result;
    }
}
// @lc code=end
//基于栈的实现
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while(!stack.isEmpty() || current!=null){
            while(current!=null ){
                stack.push(current);
                result.add(current.val);
                current = current.left;
            }
            current = stack.pop();
            current = current.right;


        }
        return result;
    }
}