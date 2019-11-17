//102. 二叉树层序遍历

//解法1：广度优先算法
//思路：通过一个队列来维护每一层获取到的节点
//时间复杂度O(N)
//空间复杂度O(N)
public List<List<Integer>> levelOrder(TreeNode root) {
	Queue<TreeNode> queue = new LinkedList<>();
	List<List<Integer>> result = new LinkedList<>();
	
	if (root == null) return result;

	queue.offer(root);
	while (!queue.isEmpty()) {
		int size = queue.size();
		LinkedList<Integer> subList = new LinkedList<>();
		for (int i = 0; i<size; i++) {
			if (queue.peek().left != null) queue.offer(queue.peek().left);
			if (queue.peek().right != null) queue.offer(queue.peek().right);
			subList.add(queue.poll().val);
		}
		result.add(subList);            
	}
	return result;
}
