//226. 翻转二叉树

//解法1：递归
//思路：从根节点开始递归,将根节点的left指向递归后的右子树,根节点的right指向递归后的左子树
//时间复杂度O(n)
//空间复杂度O(n)
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return root;
		TreeNode leftTemp = root.left;
		TreeNode rightTemp = root.right;
		root.left = invertTree(rightTemp);
		root.right = invertTree(leftTemp);
		return root;
    }
}
