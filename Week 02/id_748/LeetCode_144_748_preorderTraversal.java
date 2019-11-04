package com.code.week02;


import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LeetCode_144_748_preorderTraversal {

    /**
     * 前序遍历：根->左->右
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root,res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res){
        // 1. 递归终止条件(终止此次递归)
        if(root == null){
            return;
        }
        res.add(root.val);

        if(root.left != null){
            helper(root.left,res);
        }

        if(root.right != null){
            helper(root.right,res);
        }

    }



}
