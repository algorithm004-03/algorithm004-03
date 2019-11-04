package id_713;

import java.util.ArrayList;
import java.util.List;

/**
 * 590. N叉树的后序遍历
 */
public class LeetCode_590_NAryTreePostorderTraversal {
    /*
    思路:
    1. 二叉树遍历有2个指针, left, right. 多叉树是数组, 考虑把数组切分成 left, right的概念
     */


    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        this.helper(list, root);
        return list;
    }

    public void helper(List<Integer> list, Node root) {
        if (root == null) return;

        // 左右根
        for (int i = 0; i < root.children.size() / 2; i++) { // list前半部分, 作为左节点
            this.helper(list, root.children.get(i));
        }
        for (int i = root.children.size() / 2; i < root.children.size(); i++) { // list后半部分, 作为右节点
            this.helper(list, root.children.get(i));
        }
        list.add(root.val);
    }


    private class Node {
        public int val;
        List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}
