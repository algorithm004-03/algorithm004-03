//111. 二叉树的最小深度

//解法1：递归		执行时间击败100%
//思路：主要思路和"二叉树的最大深度"差不多, 区别在于该题是先drill down到底层, 返回到上层的时候Depth再 + 1, 而"最大深度"是drill down的同时, Depth + 1
//		求最小深度可以分为三种情况
//		1. currentNode == null		return 0
//		2. currentNode.left and right == null	return 1
//		3. currentNode.left or right == null 也就是只有一边存在深度的情况	则return leftDepth + rightDepth + 1即可, 因为此条件下, leftDepth和rightDepth必有一处 = 0
//		4. 若两边都存在子节点 也就是两边都存在深度的情况 则return 左右子树的minDepth + 1即可
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