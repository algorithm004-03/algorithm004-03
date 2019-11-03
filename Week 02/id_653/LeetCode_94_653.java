/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

/**
 * 二叉树前中后序遍历，
 * 就是指根节点元素的遍历次序，
 * 先遍历根节点就叫做前序
 * 左中右 叫做中序
 * 左右中 叫做后序
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {

    }

    void helper(TreeNode root, ArrayList<Integer> result) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, result);
            }

            result.add(root.val);

            if (root.right != null) {
                helper(root.right, result);
            }
        }

    }
}