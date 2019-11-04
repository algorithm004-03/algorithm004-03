//98. 验证是否是BSTree

//解法1：递归
//思路：重复子问题为 : 判断左节点是否小于currentNode,且右节点是否大于currentNode。
//					   那么可以得知,我们只需要将当前节点与父结点的value进行对比即可
//		terminate：当currentNode为叶子节点,return true;
//		logical：判断currentNode.val(currentNode可能为left或right)是否符合上一层递归中父结点传入的参数
//		drill down：作为父结点,传入value给下一层递归,以判断左右子节点是否符合要求
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
    
    private boolean helper(TreeNode root, long maxVal, long minVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return helper(root.left, root.val, minVal) && helper(root.right, maxVal, root.val);
    }
}


//解法2：中序遍历观察是否有序
//思路：基于二叉树中序遍历为从小到大的特性,每当进行一次中序遍历时,就与上一个节点的val值比较
//时间复杂度O(n)
//空间复杂度O(n)
//总结：活用辅助栈完成迭代式中序遍历
public boolean isValidBST(TreeNode root) {
	Stack<TreeNode> stack = new Stack<>();
	double inorder = -Double.MAX_VALUE;
	while (!stack.isEmpty() || root != null) {
		while (root != null) {
			stack.push(root);
			root = root.left;    
		}
		root = stack.pop();
		if (root.val <= inorder) return false;
		inorder = root.val;
		root = root.right;
	}
	return true;
}