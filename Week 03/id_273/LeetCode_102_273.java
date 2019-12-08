//102. 二叉树层序遍历

//解法1：广度优先算法	执行用时击败99%
//思路：通过维护一个队列遍历每一层获取到的节点
//时间复杂度O(N)
//空间复杂度O(N)
public List<List<Integer>> levelOrder(TreeNode root) {
	List<List<Integer>> result = new ArrayList<>();
	if (root == null) return result;
	Queue<TreeNode> queue = new LinkedList<>();
	queue.offer(root);
	while (!queue.isEmpty()) {
		int size = queue.size();
		List<Integer> temp = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			TreeNode curr = queue.poll();
			temp.add(curr.val);
			if (curr.left != null) queue.offer(curr.left);
			if (curr.right != null) queue.offer(curr.right);
		}
		result.add(temp);
	}
	return result;
}
