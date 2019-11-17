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
            while (size-- > 0) {
                TreeNode curr = queue.remove();
                currList.add(curr.val);
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
            list.add(currList);
        }
        return list;
    }
}