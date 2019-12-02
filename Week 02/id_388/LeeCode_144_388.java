package com.company.leetcode.editor.cn;//给定一个二叉树，返回它的 前序 遍历。
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



//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 *
 */
class TreeNode_144 {
    int val;
    TreeNode_144 left;
    TreeNode_144 right;
    TreeNode_144(int x) { val = x; }
}
class Solution_144 {

    List<Integer> res;
    public List<Integer> preorderTraversal(TreeNode_144 root) {
        res = new ArrayList<>();
        helper(root);
        return res;
    }

    //按模板编写
    private void helper(TreeNode_144 node){
        if (node == null) {
            return;
        }
        res.add(node.val);
        if (node.left != null) {
            helper(node.left);
        }
        if (node.right != null) {
            helper(node.right);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
