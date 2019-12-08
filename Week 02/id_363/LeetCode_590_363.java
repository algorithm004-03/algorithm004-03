package com.test.leetcode.week02;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class SolutionPostOrder590 {


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
        System.out.println(postorder(node1));
        System.out.println(postorder2(node1));
        System.out.println(postorder3(node1));
    }


    /**
     * 两个栈
     * 一个栈：放当前层的数据
     * 另一个栈：存放总结果数据
     *
     * @param root
     * @return
     */
    public List<Integer> postorder3(Node root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Stack<Node> levelStack = new Stack<>();
        Stack<Node> resultStack = new Stack<>();
        levelStack.push(root);
        while (!levelStack.isEmpty()) {
            Node node = levelStack.pop();
            resultStack.push(node);
            List<Node> children = node.children;
            if (children != null && children.size() > 0) {
                for (Node child : children) {
                    levelStack.push(child);
                }
            }
        }
        while (!resultStack.isEmpty()) {
            result.add(resultStack.pop().val);
        }
        return result;
    }


    /**
     * 使用一个栈：把当前node的val放到result的第0个节点
     * 把当前层的子节点数据存放到 stack中
     * @param root
     * @return
     */
    public List<Integer> postorder2(Node root) {
        List<Integer> result = new LinkedList<>();
        Stack<Node> stack = new Stack();
        if (root == null) {
            return result;
        }
        stack.push(root);
        Node top;
        int len;
        while(!stack.isEmpty()) {
            top = stack.pop();
            result.add(0, top.val);
            List<Node> children = top.children;
            if (children != null && children.size() > 0) {
                len = children.size();
                for (int i = 0; i < len; i ++) {
                    stack.push(children.get(i));
                }
            }
        }
        return result;
    }

    public List<Integer> postorder(Node root) {
        List<Integer> result = new LinkedList<>();
        helper(root, result);
        return result;
    }

    private void helper(Node root, List<Integer> result) {
        // 1.终止条件
        if (root == null) {
            return;
        }
        // 2.处理当前层
        List<Node> children = root.children;
        if (children != null && children.size() > 0) {
            for (Node child : children) {
                helper(child, result);
            }
        }
        result.add(root.val);
        // 3.下探到下一层
        // 4.清理当前层
    }

}
