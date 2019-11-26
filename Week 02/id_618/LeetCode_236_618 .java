class Solution {

	// 记录答案，如果已经找到，则终止递归
	private TreeNode ancestor;

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		this.hasMatchNode(root, p, q, 2);
		return this.ancestor;
	}

	/**
	 * 判断当前子树是否有匹配节点，特别的，当targetMatch为0时表示"无须匹配"，直接返回false
	 * 
	 * <p>
	 * 依次判断，当前根节点、左侧子树和右侧子树是否匹配，3者中只要存在一个匹配，即表示匹配，如果存在2个匹配，那么当前根节点就是公共祖先
	 * 
	 * @param current
	 * @param p
	 * @param q
	 * @param targetMatch 需要匹配的数量，其作用是避免不必要的遍历
	 * @return
	 */
	private boolean hasMatchNode(TreeNode current, TreeNode p, TreeNode q, int targetMatch) {
		// 父方法栈已经完成需要的匹配，当前栈无需继续
		if (targetMatch == 0) {
			return false;
		}

		// 已经找到的话，直接返回false终止递归
		if (this.ancestor != null) {
			return false;
		}

		if (current == null) {
			return false;
		}

		// 当前节点对应的匹配数
		int match = 0;

		// 当前是否匹配
		if (current.val == p.val || current.val == q.val) {
			targetMatch--;
			match++;
		}

		// 左侧是否匹配
		boolean leftMatch = hasMatchNode(current.left, p, q, targetMatch);
		if (leftMatch) {
			targetMatch--;
			match++;
		}

		// 右侧是否匹配
		boolean rightMatch = hasMatchNode(current.right, p, q, targetMatch);
		if (rightMatch) {
			targetMatch--;
			match++;
		}

		// 存在2个匹配，那么当前节点就是答案
		if (match == 2) {
			this.ancestor = current;
		}

		return match > 0;
	}
}