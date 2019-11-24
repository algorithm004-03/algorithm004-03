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
		if (root == null) return new ArrayList<>();
		List<List<Integer>> resultList = new ArrayList<>();
		dfs(0,root,resultList);
		return resultList;
	}

	private void dfs(int level,TreeNode root,List<List<Integer>> resultList){
		//terminator
		if (level == resultList.size()) {
			resultList.add(new ArrayList<Integer>());
		}
		//process current level logic
		resultList.get(level).add(root.val);

		//drill down
		if (root.left != null) dfs(level +1,root.left,resultList);
		if (root.right != null) dfs(level +1,root.right,resultList);
		//reverse status if need
	}

}
//leetcode submit region end(Prohibit modification and deletion)
