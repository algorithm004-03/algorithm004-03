package com.company.leetcode.editor.cn;
//您需要在二叉树的每一行中找到最大的值。
//
// 示例：
//
//
//输入:
//
//          1
//         / \
//        3   2
//       / \   \
//      5   3   9
//
//输出: [1, 3, 9]
//
// Related Topics 树 深度优先搜索 广度优先搜索



//leetcode submit region begin(Prohibit modification and deletion)

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
class TreeNode_515 {
    int val;
    TreeNode_515 left;
    TreeNode_515 right;
    TreeNode_515(int x) { val = x; }
}
class Solution_515 {
    public List<Integer> largestValues(TreeNode_515 root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode_515> queue = new LinkedList<TreeNode_515>();
        queue.addFirst(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            while (size > 0) {
                TreeNode_515 curr = queue.pollFirst();
                size--;
                max = Math.max(curr.val,max);

                if (curr.left != null) {
                    queue.addLast(curr.left);
                }
                if (curr.right != null) {
                    queue.addLast(curr.right);
                }
            }
            res.addLast(max);
        }

        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
