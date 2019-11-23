import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode_515_368 {
    /*您需要在二叉树的每一行中找到最大的值。
    https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/*/

    public static void main(String[] args) {

    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = queue.peek().val;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.val > max) {
                    max = node.val;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(max);
        }
        return res;
    }

    public List<Integer> largestValuesRecersion(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        bfs(0, root, res);
        return res;
    }

    private void bfs(int level, TreeNode node, List<Integer> res) {
        // termator
        if (node == null) {
            return;
        }
        if (level == res.size()) {
            res.set(level, node.val);
        }
        if (node.val > res.get(level)) {
            res.add(level, node.val);
        }
        bfs(level + 1, node.left, res);
        bfs(level + 1, node.right, res);
    }
}
