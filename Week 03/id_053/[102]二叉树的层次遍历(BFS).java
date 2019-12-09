//给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)


import java.util.LinkedList;
import java.util.Queue;

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
	public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}
		List<List<Integer>> resultList = new ArrayList<>();

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		//定义表示当前层数
		int level = 0;
		while (!queue.isEmpty()) {
			//还有更好的写法，直接添加一个匿名的容器元素，后面通过resultList.get(level)取出来使用
			List<Integer> tempList = new ArrayList<>();
			resultList.add(tempList);
			//process current logic

			int size = queue.size();
			for (int i = 0; i < size; i++){
				//取出当前层的全部节点
				TreeNode node = queue.poll();
				tempList.add(node.val);
				//把下一级节点添加到队列中，drill down
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			level++;
		}
		return resultList;
	}
}
//leetcode submit region end(Prohibit modification and deletion)
