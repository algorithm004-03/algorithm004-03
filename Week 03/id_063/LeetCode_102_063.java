/*
思路
进行BFS，需要注意的点是每一层的节点出队列之前先保存当前队列的长度，
否则找不到当前层和下一层节点的边界在哪

 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();

        if (root == null) {
            return result;
        }

        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> l = new ArrayList<>(len);

            while ((len--) != 0) {
                TreeNode node = queue.poll();
                l.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            result.add(l);
        }

        return result;
    }
}