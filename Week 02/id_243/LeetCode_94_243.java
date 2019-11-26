import java.util.ArrayList;
import java.util.List;

/**
 * @author eazonshaw
 * @date 2019/10/24  21:12
 *
 * 题目：94. 二叉树的中序遍历
 * 描述：给定一个二叉树，返回它的中序 遍历。
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class LeetCode_94_243 {
    class Solution {
        List<Integer> list = new ArrayList<>();
        public List<Integer> inorderTraversal(TreeNode root) {
            inorder(root);
            return list;
        }
        //递归函数
        private void inorder(TreeNode root){
            if(root == null) return;
            inorderTraversal(root.left);
            list.add(root.val);
            inorderTraversal(root.right);
        }

    }

}
