package com.company.leetcode.editor.cn;
//给定一个二叉树，返回其节点底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
//
// 例如：
//给定二叉树 [3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回其自底向上的层次遍历为：
//
// [
//  [15,7],
//  [9,20],
//  [3]
//]
//
// Related Topics 树 广度优先搜索



//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class TreeNode_107 {
    int val;
    TreeNode_107 left;
    TreeNode_107 right;
    TreeNode_107(int x) { val = x; }
}
class Solution_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode_107 root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return new ArrayList<>(res);
        }
        List<TreeNode_107> queue = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<TreeNode_107> nextQueue = new ArrayList<>();

            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < queue.size(); i++) {
                TreeNode_107 tmpNode = queue.get(i);
                level.add(queue.get(i).val);
                if (tmpNode.left != null) {
                    nextQueue.add(tmpNode.left);
                }
                if (tmpNode.right != null) {
                    nextQueue.add(tmpNode.right);
                }
            }
            res.addFirst(level);
            queue = nextQueue;
        }
        return new ArrayList<>(res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
