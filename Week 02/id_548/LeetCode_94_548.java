import java.util.ArrayList;
import java.util.List;

public class LeetCode_94_548 {
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            if (root == null) {
                return new ArrayList<> ();
            }
            List<Integer> result = new ArrayList<>();
            result.addAll(inorderTraversal(root.left));
            result.add(root.val);
            result.addAll(inorderTraversal(root.right));
            return result;
        }

    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
