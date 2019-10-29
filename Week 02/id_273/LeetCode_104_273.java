//104. 二叉树最大深度

//解法1：递归
class Solution {
    public int maxDepth(TreeNode root) {
		if (root == null) return 0;
		int leftDeep = maxDepth(root.left);
		int rightDeep = maxDepth(root.right);
		return Math.max(leftDeep, rightDeep) + 1;
	}
}
