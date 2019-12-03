package id_713;

import java.util.ArrayList;
import java.util.List;

/**
 * 589. N叉树的前序遍历
 */
public class LeetCode_589_NAryTreePreorderTraversal {

    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        this.helper(list, root);
        return list;
    }

    public void helper(List<Integer> list, Node root) {
        if (root == null) return;

        // 根左右
        list.add(root.val);
        for (int i = 0; i < root.children.size() / 2; i++) {
            this.helper(list, root.children.get(i));
        }
        for (int i = root.children.size() / 2; i < root.children.size(); i++) {
            this.helper(list, root.children.get(i));
        }
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