class Solution {
	private List<List<Integer>> ret = new ArrayList<>();

	public List<List<Integer>> levelOrder(Node root) {
		levelOrder0(root, 0);

		return ret;
	}

	private List<Integer> getCurrentLevel(int level) {
		if (level < ret.size()) {
			// 说明level层的节点已经被遍历过
			return ret.get(level);
		}

		// 遍历时，按level递增的顺序，所以直接加到最后即可
		List<Integer> currentLevel = new ArrayList<>();
		ret.add(currentLevel);

		return currentLevel;
	}

	/**
	 * 前序遍历树，将遍历到的节点放入当前层的集合中
	 * 
	 * @param root
	 * @param level
	 */
	private void levelOrder0(Node root, int level) {
		if (root == null) {
			return;
		}

		// 获取指定层的集合
		List<Integer> currentLevel = getCurrentLevel(level);

		currentLevel.add(root.val);

		List<Node> children = root.children;
		if (children != null && !children.isEmpty()) {
			for (int i = 0; i < children.size(); i++) {
				levelOrder0(children.get(i), level + 1);
			}
		}
	}
}