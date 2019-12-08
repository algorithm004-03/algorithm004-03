import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * LeetCode 144题
 *
 * @author northleaf
 * @create 2019年10月22日
 */
public class LeetCode_144_598 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 前序遍历：根左右
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        preorderTraversal(root,list);
        return list;
    }

    private void preorderTraversal(TreeNode node, List<Integer> list) {
        if(node!=null){
            list.add(node.val);
            preorderTraversal(node.left,list);
            preorderTraversal(node.right,list);
        }
    }


    /**
     * 基于栈的前序遍历：根左右
     * 1. 定义List<Integer>
     * 2. 定义栈
     * 3. 将root入栈
     * 4. 出栈，访问，将右节点入栈，将左节点入栈 循环访问
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>() ;
        }
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        //栈不空则循环
        TreeNode curr = null;
        while (!stack.isEmpty()){
            curr = stack.pop();
            if (curr != null) {
                list.add(curr.val);
                //先入右节点，再入左节点，将来就会是左节点先出
                stack.push(curr.right);
                stack.push(curr.left);
            }
        }

        return list;
    }
}
