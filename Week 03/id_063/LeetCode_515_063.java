package problem515.Solution1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/*
利用BFS做二叉树的层次遍历即可
 */


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return result;
        }

        int length = 1;
        queue.add(root);

        while (!queue.isEmpty()) {
            int nodeNum = queue.size();

            int max = Integer.MIN_VALUE;
            while ((nodeNum--) != 0) {
                TreeNode curNode = queue.poll();
                if (curNode.left != null)       queue.add(curNode.left);
                if (curNode.right != null)      queue.add(curNode.right);

                max = Math.max(max, curNode.val);
            }

            result.add(max);
            length++;
        }

        return result;
    }
}

