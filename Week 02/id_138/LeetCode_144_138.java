import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/**
 * 前序遍历
 * @author L
 *
 */
public class LeetCode_144_138 {
	/**
	 * 非递归方式-树的前序遍历:从根节点开始，每次迭代弹出当前栈顶元素，并将其孩子节点压入栈中，先压右孩子再压左孩子。
	 * 输出的最终结果顺序按照Top->Bottom和left->right，符合前序遍历的顺序。
	 * @param root
	 * @return
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<Integer> list = new ArrayList<Integer>();
		if(root == null) {
			return list;
		}
		stack.add(root);
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			list.add(node.val);
			if(node.right != null)
				stack.push(node.right);
			if(node.left != null)
				stack.push(node.left);
		}
			
		return list;
	}
}
