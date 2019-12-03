class Solution {
	private List<Integer> ret = new ArrayList<>();

	public List<Integer> postorder(Node root) {
		postorder0(root);

		return ret;
	}

	private void postorder0(Node root) {
		if (root == null) {
			return;
		}

		List<Node> children = root.children;
		if (children != null && !children.isEmpty()) {
			for (int i = 0; i < children.size(); i++) {
				postorder0(children.get(i));
			}
		}

		ret.add(root.val);
	}
}