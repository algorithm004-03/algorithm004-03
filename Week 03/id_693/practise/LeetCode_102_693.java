package id_693.practise;

import id_693.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @Desc 102. 二叉树的层次遍历    https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * @Auther 李雷(KyLin)
 * @Date 2019/10/29
 */
public class LeetCode_102_693 {
    //bfs (类似第二周的   429.N叉树的层序遍历0
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> res = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                res.add(temp.val);
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }

            list.add(res);
        }
        return list;
    }
}

