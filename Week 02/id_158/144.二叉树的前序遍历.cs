/*
 * @lc app=leetcode.cn id=144 lang=csharp
 *
 * [144] 二叉树的前序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public IList<int> PreorderTraversal(TreeNode root) {
        IList<int> res = new List<int>();
        Preorder(root,res);
        return res;
    }

    private void Preorder(TreeNode treeNode,IList<int> res){
        if(treeNode==null) return;
        res.Add(treeNode.val);
        Preorder(treeNode.left,res);
        Preorder(treeNode.right,res);
    }

    public IList<int> PreorderTraversalWithStack(TreeNode root){
        IList<int> res = new List<int>();
        if(root==null){
            return res;
        }
        TreeNode treeNode = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (treeNode!=null || stack.Count>0)
        {
            while (treeNode!=null)
            {
                res.Add(treeNode.val);
                stack.Push(treeNode);
                treeNode = treeNode.left;
            }
            if(stack.Count>0){
                treeNode=stack.Pop();
                treeNode = treeNode.right;
            }
        }
        return res;
    }
}
// @lc code=end

