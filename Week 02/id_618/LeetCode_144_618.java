class Solution {

	private List<Integer> ret = new ArrayList<>();

	public List<Integer> preorderTraversal(TreeNode root) {
		preorderTraversal0(root);

		return ret;
	}

	private void preorderTraversal0(TreeNode root) {
		if (root == null) {
			return;
		}

		ret.add(root.val);
		preorderTraversal0(root.left);
		preorderTraversal0(root.right);
	}
}