package Week02;


import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2019/10/27.
 * @see <a href="429">https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/</a>
 * N叉树的层序遍历。
 */

public class LeetCode_429_558 {
    /**
     * 解题思路：
     * 1、递归（树的前中后序遍历）
     * 2、遍历的时候带上层级
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        traversal(result, root, 0);
        return result;
    }

    public void traversal(List<List<Integer>> result, Node root, int level) {
        if (root == null) return;
        while (level >= result.size()) {
            result.add(new ArrayList<Integer>());
        }
        List<Integer> list = result.get(level);
        if (list == null) {
            list = new ArrayList<Integer>();
            result.add(level, list);
        }
        list.add(root.val);
        List<Node> children = root.children;
        if (children != null) {
            for (int i = 0; i < children.size(); i++) {
                traversal(result, children.get(i), level + 1);
            }
        }
    }


    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
