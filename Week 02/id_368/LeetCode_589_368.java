import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_589_368 {

    /*给定一个 N 叉树，返回其节点值的前序遍历。
    https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/*/

    public static void main(String[] args) {

    }

    public static List<Integer> preorderIterator(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<Node> stack = new LinkedList<>();
        stack.addFirst(root);
        while (!stack.isEmpty()) {
            Node node = stack.removeFirst();
            res.add(node.val);
            for (int i=node.children.size() - 1; i >= 0; i--) {
                stack.addFirst(node.children.get(i));
            }
        }
        return res;
    }

    public static List<Integer> preorderRecursion(Node root) {
        List<Integer> res = new ArrayList<>();
        hepler(root, res);
        return res;
    }

    public static void hepler (Node root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            for (Node node : root.children) {
                hepler(node, res);
            }
        }
    }
}
