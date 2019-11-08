//105. 从前序与中序遍历构造二叉树

//解法1：递归
//思路：根据前序遍历根左右的特性, 可以确定前序遍历第一个节点为根节点。
//		根据前序遍历根左右的特性, 搜索前序遍历中根节点的位置index, index - 1的部分即为根节点的左子树, index + 1的部分为根节点的右子树
//		那么就可以通过递归执行重复操作: 搜索根节点, 确定左子树/右子树, 就可以得到结果
//时间复杂度O(N)
//空间复杂度O(N)
public TreeNode buildTree(int[] preorder, int[] inorder) {
	return recur(preorder, inorder, 0, 0, inorder.length - 1);
}

private TreeNode recur(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
	if (preStart > preorder.length - 1 || inStart > inEnd) return null;
	TreeNode curr = new TreeNode(preorder[preStart]);
	int inIndex = 0;
	for (int i = inStart; i <= inEnd; i++) {
		if (inorder[i] == curr.val) inIndex = i;		
	}
	curr.left = recur(preorder, inorder, preStart + 1, inStart, inIndex - 1);
	curr.right = recur(preorder, inorder, preStart + inIndex - inStart + 1, inIndex + 1, inEnd);
	return curr;
}