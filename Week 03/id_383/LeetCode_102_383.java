import java.util.*;

public class LeetCode_102_383 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            this.val = x;
        }
    }

    List<List<Integer>> result = new ArrayList<List<Integer>>();

    // 方法一：递归
    public List<List<Integer>> levelOrder1(TreeNode root) {
        traversal(root, 0);
        return result;
    }

    public void traversal(TreeNode node, Integer level) {
        if (node == null) return;
        if (result.size() == level) result.add(level, new ArrayList<>());
        result.get(level).add(node.val);
        if (node.left != null) traversal(node.left, level + 1);
        if (node.right != null) traversal(node.right, level + 1);
    }

    // 方法二: 迭代
    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int length = 0;
        while (!queue.isEmpty()) {
            result.add(new ArrayList<>());
            int length2 = queue.size();
            for (int i = 0; i < length2; i++) {
                TreeNode node = queue.remove();
                result.get(length).add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            length++;
        }
        return result;
    }
}
