class Solution {
	private List<Integer> ret = new ArrayList<>();

	public List<Integer> preorder(Node root) {
		preorder0(root);

		return ret;
	}

	private void preorder0(Node root) {
		if (root == null) {
			return;
		}

		ret.add(root.val);

		List<Node> children = root.children;
		if (children != null && !children.isEmpty()) {
			for (int i = 0; i < children.size(); i++) {
				preorder0(children.get(i));
			}
		}
	}
}