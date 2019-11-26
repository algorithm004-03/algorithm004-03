/*
 * @lc app=leetcode.cn id=94 lang=csharp
 *
 * [94] 二叉树的中序遍历
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
    public IList<int> InorderTraversal(TreeNode root) {
        List<int> res = new List<int>();
        if(root==null){
            return res;
        }
        IList<int> left = InorderTraversal(root.left);
        if(left!=null && left.Any()){
            res.AddRange(left);
        }
        res.Add(root.val);
        IList<int> right= InorderTraversal(root.right);
        if(right!=null && right.Any()){
            res.AddRange(right);
        }
        return res;
    }

    public IList<int> InorderTraversal(TreeNode root){
        List<int> res = new List<int>();
        if(root==null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = root;
        while (treeNode!=null || stack.Count>0)
        {
            while (treeNode!=null)
            {
                stack.Push(treeNode);
                treeNode = treeNode.left;
            }

            if (stack.Count>0)
            {
                treeNode=stack.Pop();
                res.Add(treeNode.val);
                treeNode = treeNode.right;
            }
        }
        return res;
    }
}
// @lc code=end

