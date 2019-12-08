import java.util.ArrayList;
import java.util.List;

/**
 * @author eazonshaw
 * @date 2019/10/24  21:22
 *
 * 题目：144. 二叉树的前序遍历
 * 描述：给定一个二叉树，返回它的 前序 遍历。
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class LeetCode_144_243 {

    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            preOrder(root,list);
            return list;
        }
        //递归函数
        private void preOrder(TreeNode root,List<Integer> list){
            if(root==null) return;
            list.add(root.val);
            preOrder(root.left,list);
            preOrder(root.right,list);
        }

    }

}
