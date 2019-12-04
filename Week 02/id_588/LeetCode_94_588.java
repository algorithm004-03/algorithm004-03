import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class LeetCode_94_588 {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        _traversal(root, list);
        return list;
    }

    private void _traversal(TreeNode root, List<Integer> list) {
        if (null == root) {
            return;
        }
        if (null != root.left) {
            _traversal(root.left, list);
        }

        list.add(root.val);

        if (null != root.right) {
            _traversal(root.right, list);
        }
    }

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        node3.left = node5;
        node4.left = node6;
        node4.right = node7;

        LeetCode_94_588 solution = new LeetCode_94_588();
        System.out.println(solution.inorderTraversal(node1));


    }
}
