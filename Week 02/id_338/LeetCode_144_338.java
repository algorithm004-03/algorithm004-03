package id_338;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * User: liwei
 * Date: 2019/10/24  11:03
 * Desc:
 */
public class LeetCode_144_338 {
    List<Integer> list = new ArrayList();

    //递归, 时间复杂度 O(N)
    //空间复杂度最坏 O(N), 平均O(log)
    public List<Integer> preorderTraversal1(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();
        list.add(root.val);
        if (root.left != null) {
            preorderTraversal1(root.left);
        }
        if (root.right != null) {
            preorderTraversal1(root.right);
        }
        return list;
    }

    //思路:因为根-左-右,所以先记录根节点,再入栈左右子树,出栈的时候先出左边的
    //使用链表模拟递归过程, 时间控件复杂度都是O(N)
    //时间空间复杂度都是 O(N)
    public List<Integer> preorderTraversal2(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();
        LinkedList<TreeNode> stack = new LinkedList<>();

        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pollLast();
            list.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }

        return list;
    }
}
