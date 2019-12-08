/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode ancestor;
    public Solution() {
        this.ancestor = null;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        preOrder(root, p, q);
        return ancestor;
    }

    public boolean preOrder(TreeNode root, TreeNode p, TreeNode q) {
        if (root != null) {
            // 分两个组进行遍历
            int left = preOrder(root.left, p, q) ? 1 : 0;
            int right = preOrder(root.right, p, q) ? 1 : 0;

            int mid = (root == p || root == q) ? 1 : 0;

            //节点数量大于2 说明是公共祖先，然后向下递归
            if (mid + right + left >= 2) {
                ancestor = root;
            }
            // 判断是否含有节点
            return (left + right + mid > 0);
        }

        return false;

    }
}