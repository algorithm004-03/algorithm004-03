/*
 * @lc app=leetcode.cn id=102 lang=csharp
 *
 * [102] 二叉树的层次遍历
 */

// @lc code=start

using System.Collections.Generic;
using System.Linq;
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
    IList<IList<int>> levels = new List<IList<int>>();

     public void Dfs(TreeNode node, int level) {
        if (levels.Count == level)
            levels.Add(new List<int>());

         levels.ElementAt(level).Add(node.val);

         if (node.left != null)
            Dfs(node.left, level + 1);
         if (node.right != null)
            Dfs(node.right, level + 1);
    }
    public IList<IList<int>> LevelOrder(TreeNode root) {
        if(root==null){
            return levels;
        }
        Dfs(root,0);
        return levels;
    }

}
// @lc code=end

