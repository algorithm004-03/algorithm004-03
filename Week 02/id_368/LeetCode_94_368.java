import java.util.ArrayList;
import java.util.List;

public class LeetCode_94_368 {

    /*给定一个二叉树，返回它的中序 遍历。
    https://leetcode-cn.com/problems/binary-tree-inorder-traversal/*/

    public static void main(String[] args) {

    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public static void helper (TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }
}
