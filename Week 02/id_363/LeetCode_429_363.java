package com.test.leetcode.week02;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class SolutionLevelOrder429 {


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
        System.out.println(levelOrder(node1));
        System.out.println(levelOrder2(node1));
        System.out.println(levelOrderBetter(node1));
    }


    /**
     * 使用LinkedList是时候最好不适用i遍历
     * 最好使用poll这种 O(1)时间复杂度来遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> levelNodes = new LinkedList<>();
        levelNodes.add(root);
        while(levelNodes.size() > 0) {
            List<Integer> segResult = new LinkedList<>();
            int size = levelNodes.size();
            Queue<Node> childNodes = new LinkedList<>();
            while (size > 0) {
                Node node = levelNodes.poll();
                segResult.add(node.val);
                if (node.children != null && node.children.size() > 0 ) {
                    childNodes.addAll(node.children);
                }
                size --;
            }
            result.add(segResult);
            levelNodes = childNodes;
        }
        return result;
    }


    // queue中可以使用count来表示当前层有哪些数据
    public List<List<Integer>> levelOrderBetter(Node root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> curLevel = new LinkedList<>();
            int len = queue.size();
            for (int i = 0; i < len; i ++) {
                Node node = queue.poll();
                curLevel.add(node.val);
                if (node.children != null) {
                    queue.addAll(node.children);
                }
            }
            result.add(curLevel);
        }
        return result;
    }


    /**
     * 重复子问题：获取每一层的list 增加当前节点的值到list中
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, 0, result);
        return result;
    }

    private void helper(Node root, int depth, List<List<Integer>> result) {
        // 递归终止条件
        if (root == null) {
            return;
        }
        // 处理当前层
        if (depth + 1 > result.size()) {
            result.add(new LinkedList<>());
        }
        result.get(depth).add(root.val);
        // 下探到下一层
        List<Node> children = root.children;
        if (children != null && children.size() > 0) {
            for (Node child : children) {
                helper(child, depth + 1, result);
            }
        }
        // 清理当前层

    }

}
