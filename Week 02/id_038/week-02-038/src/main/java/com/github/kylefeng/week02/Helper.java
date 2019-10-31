package com.github.kylefeng.week02;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author kylefeng
 * @time 2019/10/26 10:49
 */
public class Helper {

    /**
     * 方便构建树的辅助方法:
     *
     * @param values
     * @return
     */
    public static Node node(Object... values) {
        if (values.length == 1) {
            return new Node((Integer) values[0], null);
        }

        List<Node> children = Lists.newArrayListWithCapacity(values.length - 1);
        for (int i = 1; i < values.length; i++) {
            Object val = values[i];
            if (val instanceof Node) {
                children.add((Node) val);
            } else {
                children.add(new Node((Integer) values[i], null));
            }
        }
        return new Node((Integer) values[0], children);
    }

    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
