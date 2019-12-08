//104. 二叉树最大深度

//解法1：递归		执行用时击败100%
//思路：每drill down一次, 深度+1, 最后返回左右子树的最大深度即可
//时间复杂度：O(n)
//空间复杂度：O(n)
class Solution {
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }
}

//解法2：BFS	执行用时击败89%
//思路：通过维护一个栈记录每一层的节点, 若当前层节点还存在孩子节点, 下探到下一层, level + 1
//时间复杂度：O(n)
//空间复杂度：O(n)
public int maxDepth(TreeNode root) {
	if (root == null) return 0;
	Queue<TreeNode> queue = new LinkedList<>();
	queue.offer(root);
	int level = 0;
	while (!queue.isEmpty()) {
		int size = queue.size();
		level++;
		for (int i = 0; i < size; i++) {
			TreeNode curr = queue.poll();
			if (curr.left != null) queue.offer(curr.left);
			if (curr.right != null) queue.offer(curr.right);
		}
	}
	return level;
}