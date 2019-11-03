package com.github.kylefeng.week02;

import com.github.kylefeng.week02.Helper.Node;

import java.util.*;

/**
 * 429. N叉树的层序遍历
 *
 * @author kylefeng
 * @time 2019/10/26 10:48
 */
public class LeetCode_429_038 {

    /**
     * 进行层序遍历
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }

        Map<Integer, List<Integer>> table = new HashMap<>();
        traverse(root, 1, table);

        // Add first element first
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(root.val);
        result.add(first);

        // Collect children
        for (int i = 0; i < table.size(); i++) {
            result.add(table.get(i + 1));
        }

        return result;
    }

    private static void traverse(Node parent,
                                 int level,
                                 Map<Integer, List<Integer>> table) {
        if (parent.children == null || parent.children.isEmpty()) {
            return;
        }

        // Visit children
        int childrenSize = parent.children.size();
        List<Integer> childrenData = new ArrayList<>(childrenSize);
        for (Node child : parent.children) {
            childrenData.add(child.val);
        }

        List<Integer> sameLevelData = table.get(level);
        if (sameLevelData == null) {
            sameLevelData = new ArrayList<>();
            table.put(level, sameLevelData);
        }
        sameLevelData.addAll(childrenData);


        // Drill down
        for (Node child : parent.children) {
            traverse(child, level + 1, table);
        }
    }
}
