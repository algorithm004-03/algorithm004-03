/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currList = new LinkedList<>();
            TreeNode currNode = null;
            while (size-- > 0) {
               currNode = queue.poll();
               currList.add(currNode.val);
               if (currNode.left != null) queue.offer(currNode.left);
               if (currNode.right != null) queue.offer(currNode.right);
            }
            list.add(currList);
        }
        return list;
    }
}