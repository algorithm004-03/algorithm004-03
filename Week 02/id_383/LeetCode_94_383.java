import java.util.LinkedList;
import java.util.List;

public class LeetCode_94_383 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        traversing(root, result);
        return result;
    }

    public void traversing(TreeNode node, List<Integer> result) {
        if (node == null) return;
        if (node.left != null) traversing(node.left, result);
        result.add(node.val);
        if (node.right != null) traversing(node.right, result);
    }

}
