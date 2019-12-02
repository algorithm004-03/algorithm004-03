//226. 翻转二叉树

//解法1：递归		执行用时击败100%
//思路：从根节点开始递归,将根节点的left指向递归后的右子树,根节点的right指向递归后的左子树
//时间复杂度O(n)
//空间复杂度O(n)
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        root.right = invertTree(leftNode);
        root.left = invertTree(rightNode);
        return root;
    }
}
