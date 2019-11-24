package com.code.top;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class LeetCode_94_748_inorderTraversal {

    /**
     * 递归解法
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // 定义一个容器来存储中序遍历出的数字
        List<Integer> res = new ArrayList<Integer>();
        helper(root,res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res){
        // 第一步：判断终止条件
        if(root != null){
            // 第二步：处理当前层(中序遍历：左-> 中-> 右)
            // 1. 先判断左边是否为空，不为空则进左节点继续遍历，直到为空为止
            if(root.left != null){
                // 第三步：处理下一层(注意：下一层根节点是当前节点的左节点)
                helper(root.left,res);
            }
            // 2. 添加根节点至容器中(根节点在最开始就已经判断了，如果为空直接终止循环)
            res.add(root.val);

            // 3. 判断右节点(做法同左节点类似)
            if(root.right != null){
                // 第三步：处理下一层(注意：下一层根节点是当前节点的右节点)
                helper(root.right,res);
            }
        }

    }

    /**
     * 基于栈的写法
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalStack(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()){
            // 1. 先搞一波，找到最左侧的节点,并且把每一层的root节点都入栈(最左元素的相当于没有左右节点的root)
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }

            // 2. 搞完上面的一波之后，栈里面存了所有的root节点和左节点，现在开始出栈
            // 第一个出的肯定是最左的节点的值
            curr = stack.pop();
            res.add(curr.val);
            // 设置为右节点，到外层循环
            curr = curr.right;

        }
        return res;
    }


}
