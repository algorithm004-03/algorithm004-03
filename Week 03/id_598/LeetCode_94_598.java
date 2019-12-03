import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * @author northleaf
 * @create 2019年10月30日
 */
public class LeetCode_94_598 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    /**
     * 中序遍历：左根右
     *  递归做法
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root,list);
        return list;
    }


    /**
     * 中序遍历
     * @param node
     * @param list
     */
    private void inorderTraversal(TreeNode node, List<Integer> list) {
        if (node != null) {
            inorderTraversal(node.left,list);
            list.add(node.val);
            inorderTraversal(node.right,list);
        }
    }


    /**
     * 中序遍历：迭代法
     *  左根右
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack < TreeNode > stack = new Stack < > ();
        TreeNode curr = root;
        //当前的节点不为null
        //并且栈不为空
        while (curr != null || !stack.isEmpty()) {
            //节点不为空
            //持续循环，将节点的左子树全部入栈
            while (curr != null) {
                //将节点入栈
                stack.push(curr);
                curr = curr.left;
            }
            //将栈顶元素出栈，此时一定是左节点
            curr = stack.pop();
            list .add(curr.val);
            //获取它的右子树
            curr = curr.right;
        }
        return list;
    }
}
