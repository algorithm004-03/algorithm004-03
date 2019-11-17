import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层次遍历
 * @author L
 *
 */
public class LeetCode_102_138 {
	
	public List<List<Integer>> levelOrder(TreeNode root) {
		//最终结果输出
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(root == null)
			return res;
		//历史访问记录
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int level = 0;
		while(!queue.isEmpty()) {
			//每一层初始化一个结果集合保存访问的数据
			res.add(new ArrayList<Integer>());
			int size = queue.size();
			for(int i=0;i<size;i++) {//遍历上一层访问记录,注意此处不能使用for each，否则提示异常
				TreeNode node = queue.remove();
				res.get(level).add(node.val);
				if(node.left != null) {
					queue.offer(node.left);
				}
				if(node.right != null) {
					queue.offer(node.right);
				}
			}
			level++;
		}
		return res;
	}
	
}
