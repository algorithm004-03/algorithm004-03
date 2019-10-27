package com.github.kylefeng.week02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.github.kylefeng.week02.Helper.TreeNode;

/**
 * 144. 二叉树的前序遍历
 *
 * @author kylefeng
 * @time 2019/10/26 21:45
 */
public class LeetCode_144_038 {
    public static List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> collector = new ArrayList<>();
        recurTraverse(root, collector);
        return collector;
    }

    private static void recurTraverse(TreeNode node, List<Integer> collector) {
        if (node == null) {
            return;
        }

        collector.add(node.val);
        recurTraverse(node.left, collector);
        recurTraverse(node.right, collector);
    }
}
