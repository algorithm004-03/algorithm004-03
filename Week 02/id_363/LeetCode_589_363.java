package com.test.leetcode.week02;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class SolutionPreOrder589 {


    @Test
    public void test1() {
        Node node1 = new Node(); node1.val = 1;
        Node node2 = new Node(); node2.val = 2;
        Node node3 = new Node(); node3.val = 3;
        Node node4 = new Node(); node4.val = 4;
        Node node5 = new Node(); node5.val = 5;
        Node node6 = new Node(); node6.val = 6;
        Node node7 = new Node(); node7.val = 7;
        node1.children = Arrays.asList(node3, node2, node4);
        node3.children = Arrays.asList(node5, node6);
        System.out.println(preorder(node1));
        System.out.println(preorder2(node1));

    }


    /**
     * stack : 出栈 + result + 存放子节点
     * @param root
     * @return
     */
    public List<Integer> preorder2(Node root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return  result;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (! stack.isEmpty()) {
            Node node = stack.pop();
            result.add(node.val);
            List<Node> children = node.children;
            if (children != null && children.size() > 0) {
                for (int i = children.size() - 1; i >= 0; i --) {
                    stack.push(children.get(i));
                }
            }
        }
        return result;
    }


    /**
     * N 叉树的前序遍历  中左右
     * 1.递归
     * 2.栈
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        List<Integer> result = new LinkedList<>();
        helper(root, result);
        return result;
    }

    private void helper(Node root, List<Integer> result) {
        // 1. 终止条件
        if (root == null) {
            return;
        }
        // 2. 处理当前层
        result.add(root.val);
        // 3. 下探到下一层
        List<Node> children = root.children;
        if (children != null && children.size() > 0) {
            for (Node child : children) {
                helper(child, result);
            }
        }
        // 4. 清理当前层
    }

}
