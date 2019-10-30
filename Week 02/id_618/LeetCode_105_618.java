class Solution1 {
	/**
	 * “preorder 中的第一个元素一定是树的根，这个根又将 inorder
	 * 序列分成了左右两棵子树”，此方案性能不佳，因为在迭代里存在构建新数组和哈希集合，后又了写了Solution2
	 * 
	 * @param preorder
	 * @param inorder
	 * @return
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
			return null;
		}

		// 构建根节点
		int rootVal = preorder[0];
		TreeNode rootNode = new TreeNode(rootVal);

		if (preorder.length == 1) {
			return rootNode;
		}

		// 构建左中序和右中序
		int[] leftInorder = null;
		int[] rightInorder = null;

		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == rootVal) {
				leftInorder = new int[i];
				rightInorder = new int[inorder.length - i - 1];

				System.arraycopy(inorder, 0, leftInorder, 0, leftInorder.length);
				System.arraycopy(inorder, i + 1, rightInorder, 0, rightInorder.length);

				break;
			}
		}

		// 构建左前序和右前序
		Set<Integer> leftVals = new HashSet<>();
		Set<Integer> rightVals = new HashSet<>();

		for (int i = 0; i < leftInorder.length; i++) {
			leftVals.add(leftInorder[i]);
		}

		for (int i = 0; i < rightInorder.length; i++) {
			rightVals.add(rightInorder[i]);
		}

		int[] leftPreorder = new int[leftInorder.length];
		int[] rightPreorder = new int[rightInorder.length];

		for (int i = 1, left = 0, right = 0; i < preorder.length; i++) {
			int val = preorder[i];

			if (leftVals.contains(val)) {
				leftPreorder[left++] = val;
			} else if (rightVals.contains(val)) {
				rightPreorder[right++] = val;
			}
		}

		rootNode.left = this.buildTree(leftPreorder, leftInorder);
		rootNode.right = this.buildTree(rightPreorder, rightInorder);

		return rootNode;
	}

}

class Solution2 {
	private int[] preorder;
	private int preorderIndex = 0;
	private Map<Integer/* val */, Integer/* index */> inorderIndexMap;

	/**
	 * 将数组拷贝的思路改为中序数组左右边界指针变动，不在迭代中产生新的数组
	 * 
	 * @param preorder
	 * @param inorder
	 * @return
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		this.preorder = preorder;
		this.inorderIndexMap = new HashMap<>(inorder.length, 1);

		// 构建值在中序数组里的索引，可以快速将中序数组按根节点分为左右两边
		for (int i = 0; i < inorder.length; i++) {
			inorderIndexMap.put(inorder[i], i);
		}

		// 开始迭代，起始边界是中序数组的左右边界
		return this.buildTree0(0, inorder.length);
	}

	private TreeNode buildTree0(int inorderLeft, int inorderRight) {
		// 终止条件
		if (inorderLeft == inorderRight) {
			return null;
		}

		// 前序数组始终为当前迭代子树的根节点，取完后自增，定位下一个子树的根节点
		int rootVal = this.preorder[preorderIndex++];
		TreeNode root = new TreeNode(rootVal);

		// 获取根节点在中序数组的索引
		int inorderSplit = this.inorderIndexMap.get(rootVal);

		// 根据索引，将中序数组分为左右两个边界，递归执行，分别获取左右节点
		root.left = this.buildTree0(inorderLeft, inorderSplit);
		root.right = this.buildTree0(inorderSplit + 1, inorderRight);

		return root;
	}
}