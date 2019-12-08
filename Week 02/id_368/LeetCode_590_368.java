import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_590_368 {

    /*给定一个 N 叉树，返回其节点值的后序遍历。
    https://leetcode-cn.com/problems/group-anagrams/*/

    public static void main(String[] args) {

    }

    public static List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<Node> stack = new LinkedList<>();
        stack.addFirst(root);
        while(!stack.isEmpty()){
            Node node = stack.removeFirst();
            res.add(node.val);
            for (Node no : node.children) {
                stack.addFirst(no);
            }

        }
        Collections.reverse(res);
        return res;
    }

    public static List<Integer> postorderRecursion(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(root, res);
        return res;
    }

    public static void helper (Node root, List<Integer> res) {
        if (root != null) {
            for (Node node : root.children) {
                helper(node, res);
            }
            res.add(root.val);
        }
    }
}
