package com.company.leetcode.editor.cn;
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



//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.

 */
class TreeNode_94 {
    int val;
    TreeNode_94 left;
    TreeNode_94 right;
    TreeNode_94(int x) { val = x; }
}
class Solution_94 {

    private List<Integer> res;

    /**
     * 栈的方式
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode_94 root) {
        res = new ArrayList<>();
        Stack<TreeNode_94> stack = new Stack();
        TreeNode_94 curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }

        return res;
    }

    //递归方式
    public List<Integer> inorderTraversal2(TreeNode_94 root) {
        res = new ArrayList<>();
        travel(root);
        return res;
    }

    private void travel(TreeNode_94 node){

        if (node == null){
            return;
        }

        if (node.left != null) {
            travel(node.left);
        }
        res.add(node.val);
        if (node.right != null) {
            travel(node.right);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
