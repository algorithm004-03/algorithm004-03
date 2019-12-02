package com.test.leetcode.week02;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;


public class SolutionLowestCommonAncestor236 {


    @Test
    public void test1() {
        TreeNode node0 = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);

        node3.left = node5;
        node3.right = node1;
        node5.left = node6;
        node5.right = node2;
        node1.left = node0;
        node1.right = node8;
        node2.left = node7;
        node2.right = node4;

//        System.out.println(lowestCommonAncestor1(node3, node5, node4));
        System.out.println(lowestCommonAncestor2(node3, node5, node4));
        System.out.println(lowestCommonAncestor3(node3, node5, node4));
    }


    /**
     * 判断左子树中是否存在p/q
     * 判断右子树中是否存在p/q
     * 如果左子树没有，那么返回右子树的值
     * 如果左子树有p/q 并且右子树没有p/q 那么返回左节点 否则返回root
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor3(root.left, p, q); // 左子树中的返回值
        TreeNode right = lowestCommonAncestor3(root.right, p, q); // 右子树中的返回值
        // 对于每一个节点
        if (left != null && right != null) return root; // 说明根节点是最近公共祖先
        return left == null ? right : left; // 返回其中一个节点，表示p/q 存在
    }


    /**
     * 使用父指针
     * 思路：
     * 记录每个节点以及父指针
     * 获取p的所有父节点
     * 获取q的父节点，当q的父节点在p的父节点集合中存在的时候，那么这个节点就是最近公共祖先
     *
     * 优点：简单暴力，思路简单
     * 缺点：需要保留所有节点和父节点之间的关系，内存占用较大。
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        Map<TreeNode, TreeNode> parents = new HashMap<>();

        while (!parents.containsKey(p) || !parents.containsKey(q)) {
            TreeNode node = stack.pop();
            if (node == null) {
                break;
            }
            if (node.left != null) {
                stack.push(node.left);
                parents.put(node.left, node);
            }
            if (node.right != null) {
                stack.push(node.right);
                parents.put(node.right, node);
            }
        }
        if (!parents.containsKey(p) || !parents.containsKey(q)) {
            return root;
        }

        Set<TreeNode> ancestors = new HashSet();
        while (p != null) {
            ancestors.add(p);
            p = parents.get(p);
        }

        while (!ancestors.contains(q)) {
            q = parents.get(q);
        }
        return q;
    }



    /**
     * 当树的根节点 左子树 或者 右子树中包含这个值的时候，那么根节点就是结果
     * @param root
     * @param p
     * @param q
     * @return
     */
    TreeNode result = null;
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        recurseTree(root, p, q);
        return result;
    }

    private Boolean recurseTree(TreeNode root, TreeNode p, TreeNode q) {
        // 递归终止条件
        if (root == null) return false;
        // 处理当前层的问题 如果当前节点 和 左右节点中有两个节点 是p/q ,那么返回mid
        int mid = (root == p || root == q) ? 1 : 0;
        // 下探到下一层
        int left = recurseTree(root.left, p, q) ? 1 : 0;
        int right = recurseTree(root.right, p, q) ? 1 : 0;
        // 合并
        if (mid + left + right >= 2) {
            this.result = root;
            return true;
        }
        // 清理当前层
        return (mid + left + right) > 0;
    }

}
