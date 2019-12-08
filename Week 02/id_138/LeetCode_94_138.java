import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历
 * @author L
 *
 */
public class LeetCode_94_138 {
	/**
	 * 递归方法
	 * 时间复杂度O(n)
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal_solution1(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		inorderFindNode(root,list);
		return list;
	}

	private void inorderFindNode(TreeNode root, List<Integer> list) {
		if(root == null) {
			return ;
		}
		inorderFindNode(root.left, list);
		list.add(root.val);
		inorderFindNode(root.right, list);
		
		/**
		 * 前序遍历
		 */
//		list.add(root.val);
//		inorderFindNode(root.left, list);
//		inorderFindNode(root.right, list);
		
		/**
		 * 后序遍历
		 */
//		inorderFindNode(root.left, list);
//		inorderFindNode(root.right, list);
//		list.add(root.val);
	}
	
	/**
	 * 非递归方式
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal_solution2(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack();
		stack.add(root);
		TreeNode current = root;
		int i=0;
		while(current !=null || !stack.isEmpty()) {
			while(current != null) {//当前树的所有左孩子入栈
				stack.push(current);
				current = current.left;
			}
			current = stack.pop();//左孩子出栈
			list.add(current.val);//左孩子也是某个中间（根）节点
			current = current.right;
		}
		
		return list;
	}
}
