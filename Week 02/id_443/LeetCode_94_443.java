//给定一个二叉树，返回它的中序 遍历。
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
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表

package com.modds.alltest.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode_94_443_BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new LeetCode_94_443_BinaryTreeInorderTraversal().new Solution();
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
        List<Integer> list = new ArrayList<>();

        public List<Integer> inorderTraversal(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode node = root;
            while (node != null || !stack.empty()) {
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }

                node = stack.pop();
                list.add(node.val);
                node = node.right;
            }
            return list;
        }

        public List<Integer> inorderTraversal1(TreeNode root) {
            if (root == null) return list;

            inorderTraversal(root.left);
            list.add(root.val);
            inorderTraversal(root.right);

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
