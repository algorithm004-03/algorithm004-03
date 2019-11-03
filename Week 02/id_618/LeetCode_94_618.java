class Solution {

	private List<Integer> ret = new ArrayList<>();

	public List<Integer> inorderTraversal(TreeNode root) {
		inorderTraversal0(root);

		return ret;
	}

	private void inorderTraversal0(TreeNode root) {
		if (root == null) {
			return;
		}

		inorderTraversal0(root.left);
		ret.add(root.val);
		inorderTraversal0(root.right);
	}
}