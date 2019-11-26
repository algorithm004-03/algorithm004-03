//105. 从前序与中序遍历构造二叉树

//解法1：递归		执行用时击败约54%
//思路：根据前序遍历根左右的特性, 可以确定前序遍历第一个节点为根节点。
//		通过前序遍历获取到根节点后, 再通过中序遍历的特性, 可以寻找到该结点的左/右子节点
//			中序遍历中：左节点位于数组上的坐标就是根节点的左半部分, 同理右节点 
//时间复杂度O(N)
//空间复杂度O(N)
public TreeNode buildTree(int[] preorder, int[] inorder) {
	return recur(preorder, inorder, 0, 0, inorder.length - 1);
}

private TreeNode recur(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
	if (preStart > preorder.length - 1 || inStart > inEnd) {
		return null;
	}
	TreeNode curr = new TreeNode(preorder[preStart]);
	int index = 0;
	for (int i = inStart; i <= inEnd; i++) {
		if (inorder[i] == curr.val) {
			index = i;
			break;
		}
	}
	curr.left = recur(preorder, inorder, preStart + 1, inStart, index - 1);
	curr.right = recur(preorder, inorder, preStart + 1 + index - inStart, index + 1, inEnd);
	return curr;
}