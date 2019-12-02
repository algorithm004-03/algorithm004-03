import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_104_368 {

    /*给定一个二叉树，找出其最大深度。
    二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
    说明: 叶子节点是指没有子节点的节点。
    https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/public*/

    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        return depth(root, 0);
    }

    private int depth(TreeNode root, int depth) {
        // terminator
        if (root == null) {
            return depth;
        }
        // process current logic
        depth++;
        // drill down
        int maxLeft = depth(root.left, depth);
        int maxRight = depth(root.right, depth);
        // reverse states
        return Math.max(maxLeft, maxRight);
    }

    public int maxDepthDFS(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> depth = new LinkedList<>();
        queue.add(root);
        depth.add(1);
        int dep = 0;
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            int temp = depth.poll();
            dep = Math.max(temp, dep);
            if (curr.left != null) {
                queue.add(curr.left);
                depth.add(temp + 1);
            }
            if (curr.right != null) {
                queue.add(curr.right);
                depth.add(temp + 1);
            }
        }
        return dep;
    }

    public int maxDepthBFS(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
        }
        return depth;
    }
}
