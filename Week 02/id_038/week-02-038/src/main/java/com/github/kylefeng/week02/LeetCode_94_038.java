package com.github.kylefeng.week02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.github.kylefeng.week02.Helper.TreeNode;

/**
 * 94. 二叉树的中序遍历
 *
 * @author kylefeng
 * @time 2019/10/26 12:08
 */
public class LeetCode_94_038 {

    public static List<Integer> inorderTraversal(TreeNode root) {
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
        recurTraverse(node.left, collector);
        collector.add(node.val);
        recurTraverse(node.right, collector);
    }

}
