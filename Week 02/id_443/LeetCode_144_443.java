//给定一个二叉树，返回它的 前序 遍历。
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树

package com.modds.alltest.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode_144_443_BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new LeetCode_144_443_BinaryTreePreorderTraversal().new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        private List<Integer> list = new ArrayList<>();

        /**
         * 循环
         *
         * @param root
         * @return
         */
        public List<Integer> preorderTraversal(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            if (root == null) return list;
            stack.add(root);
            while (!stack.empty()) {
                TreeNode node = stack.pop();

                list.add(node.val);
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
            return list;
        }

        /**
         * 递归
         *
         * @param root
         * @return
         */
        public List<Integer> preorderTraversal1(TreeNode root) {
            if (root == null) return list;
            list.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}