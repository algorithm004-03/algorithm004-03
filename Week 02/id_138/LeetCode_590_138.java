import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * n叉树的后序遍历
 * @author L
 *
 */
public class LeetCode_590_138 {
	
	/**
	 * 递归法-1
	 * @param root
	 * @return
	 */
    public List<Integer> postorder_solution1(Node root) {
    	List<Integer> list = new ArrayList<Integer>();
    	if(root == null)
    		return list;
    	postorderNode(root, list);
    	return null;
    }

	private void postorderNode(Node root, List<Integer> list) {
		if(root == null) {
			return ;
		}
		for(Node node: root.children) {
			postorderNode(node, list);
		}
		list.add(root.val);
	}
	
	/**
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> postorder_solution2(Node root) {
    	List<Integer> list = new ArrayList<Integer>();
    	if(root == null)
    		return list;
    	Stack<Node> stack = new Stack();
    	stack.push(root);//根节点最先入栈
    	//上次处理的节点
    	Node pre = null;
    	while(!stack.isEmpty()) {
    		Node cur = stack.peek();
    		if((cur.children.size()==0) || (pre!=null && cur.children.contains(pre))) {
    			//加入结果集
    			list.add(cur.val);
    			stack.pop();
    			//更新pre节点
    			pre = cur;
    		}else {
    			List<Node> nodes = cur.children;
    			for(int i=nodes.size()-1;i>0;i--) {//从右到左入栈
    				stack.push(nodes.get(i));
    			}
    		}
    	}
    	return list;
    }
}
