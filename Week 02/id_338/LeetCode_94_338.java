package id_338;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中序遍历
 * Desc:
 */
public class LeetCode_94_338 {
    List<Integer> list = new ArrayList();

    //递归, 时间复杂度 O(N)
    //空间复杂度最坏 O(N), 平均O(log)
    public List<Integer> inorderTraversal1(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();
        if (root.left != null) {
            inorderTraversal1(root.left);
        }
        list.add(root.val);
        if (root.right != null) {
            inorderTraversal1(root.right);
        }
        return list;
    }

    //使用栈模拟递归过程, 时间控件复杂度都是O(N)
    //时间空间复杂度都是 O(N)
    public List<Integer> inorderTraversal2(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();

        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;

        while(cur!=null || !stack.empty()){
            while(cur!=null){
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }

        return list;
    }
}
