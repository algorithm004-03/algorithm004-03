//您需要在二叉树的每一行中找到最大的值。 
//
// 示例： 
//
// 
//输入: 
//
//          1
//         / \
//        3   2
//       / \   \  
//      5   3   9 
//
//输出: [1, 3, 9]
// 
// Related Topics 树 深度优先搜索 广度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)

import org.w3c.dom.Element;

import java.util.Arrays;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
	public List<Integer> largestValues(TreeNode root) {
		//BFS
		if (root == null) return new ArrayList<>();
		int level = 0;
		List<Integer> resultList = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			 //每一层定义一个集合存放所有的节点值
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				max = Math.max(node.val,max);
				if (node.left != null) queue.offer(node.left);
				if (node.right != null) queue.offer(node.right);
			}
			//将最大值加到resultList中
			resultList.add(max);
			//继续下一层
			level++;
		}
		return resultList;

	}
}
//leetcode submit region end(Prohibit modification and deletion)
