package com.test.leetcode.week02;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import static com.sun.tools.internal.xjc.reader.Ring.add;


public class SolutionInorderTraversal94 {


    @Test
    public void test1() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.right = node2;
        node2.left = node3;
        inorderTraversal_digui(node1);
        System.out.println(inorderTraversal0(node1));
        System.out.println(inorderTraversal2(node1));
    }


    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            // 处理左节点 所有的左节点入栈
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;
        }
        return result;
    }

    /**
     * 递归：自己掉用自己
     * @param root
     */
    public void inorderTraversal_digui(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal_digui(root.left);
        System.out.println(root.val);
        inorderTraversal_digui(root.right);
    }


    public List<Integer> inorderTraversal0(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        helper(root, result);
        return result;
    }

    private void helper(TreeNode root, List<Integer> result) {
        // 1.终止条件
        if (root == null) {
            return;
        }
        // 2.处理当前层
        helper(root.left, result);
        result.add(root.val);
        // 3.下探到下一层
        helper(root.right, result);
        // 4.清理当前层的状态
    }


}
