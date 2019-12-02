package com.test.leetcode.week02;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class SolutionPreOrdertraversal144 {


    @Test
    public void test1() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.right = node3;
        node1.left = node2;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        System.out.println(preorderTraversal_20191026_1(node1));
        System.out.println(preorderTraversal_20191026_2(node1));
        System.out.println(preorderTraversal_20191026_3(node1));
    }



    /**
     * 递归: 时间复杂度是O(n) 空间复杂度是O(n)
     * 栈:时间复杂度是O(n) 空间复杂度是O(n)
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal_20191026_1(TreeNode root) {
       List<Integer> result = new LinkedList<>();
       helper_20191026_1(root, result);
       return result;
    }

    private void helper_20191026_1(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        helper_20191026_1(root.left, result);
        helper_20191026_1(root.right, result);
    }

    public List<Integer> preorderTraversal_20191026_2(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if(root == null) {
            return  result;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            result.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return result;
    }



    // 循环左节点的时候 把中间和左边数据加入到结果中
    // 栈弹出的时候，取右边数据好了
    public List<Integer> preorderTraversal_20191026_3(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>(); // 保证加入和取出是在同一段
        TreeNode  cur = root;
        while(cur != null || !stack.isEmpty()) {
            while (cur != null) {
                result.add(cur.val);
                stack.addFirst(cur);
                cur = cur.left;
            }
            cur = stack.pollFirst().right;
        }
        return result;
    }

    // 左中右: 因为要先取左边的数据 所以吧左边数据全部加入到栈内 然后再取出
    // 这样左边数据就是在前面
    // 再取出的就是中间的数据
    // pop : 左边数据 | 中间数据  切换右边数据
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

}
