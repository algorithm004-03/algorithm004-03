//111. 二叉树的最小深度

//解法1：递归
//思路：求最小深度可以分为三种情况
//		1. currentNode == null		return 0
//		2. currentNode.left and right == null	return 1
//		3. currentNode.left or right == null 也就是只有一边存在深度的情况	则return Depth即可
//		4. 若两边都存在子节点 也就是两边都存在深度的情况 则return minDepth即可
//时间复杂度O(n) 
//空间复杂度O(logN) 但最坏情况下二叉树为链式结构时,递归会调用N次,空间复杂度为O(N)
class Solution {
    public int minDepth(TreeNode root) {
		if (root == null) return 0;
		if (root.left == null && root.right == null) return 1;
		int leftDeep = minDepth(root.left);
		int rightDeep = minDepth(root.right);
		//若左右节点存在一个为null,那么必定有一个深度为0
		if (root.left == null || root.right == null) {
			return leftDeep + rightDeep + 1;
		}
		//若左右节点都不为空,返回一个较小值
		return Math.min(leftDeep, rightDeep) + 1;
	}
}