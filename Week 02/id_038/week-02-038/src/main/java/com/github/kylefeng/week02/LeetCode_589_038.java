package com.github.kylefeng.week02;

import java.util.*;

import static com.github.kylefeng.week02.Helper.Node;

/**
 * 589. N叉树的前序遍历
 *
 * @author kylefeng
 * @time 2019/10/27 10:37
 */
public class LeetCode_589_038 {

    public static List<Integer> preorder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }

        if (root.children == null || root.children.isEmpty()) {
            List<Integer> result = new ArrayList<>(1);
            result.add(root.val);
            return result;
        }

        List<Integer> result = new ArrayList<>();
        traverse(root, new HashSet<>(), result);
        return result;
    }

    private static void traverse(Node node, Set<Node> visited, List<Integer> collector) {
        if (node.children == null || node.children.isEmpty()) {
            return;
        }

        if (!visited.contains(node)) {
            collector.add(node.val);
            visited.add(node);
        }

        // Visit children
        Set<Integer> set = new HashSet<>();
        for (Node child : node.children) {
            traverse(child, visited, collector);
            set.add(child.val);
            if (!visited.contains(child)) {
                collector.add(child.val);
                visited.add(child);
            }
        }


    }
}
