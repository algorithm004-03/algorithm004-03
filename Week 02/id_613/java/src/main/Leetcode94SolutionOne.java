import java.util.ArrayList;
import java.util.List;

/**
 * 中序遍历，使用递归
 *
 * 时间复杂度O(n)，空间复杂度O(n)
 *
 * 执行用时 : * 1 ms * , 在所有 java 提交中击败了 * 96.47% * 的用户
 * 内存消耗 : * 34.6 MB * , 在所有 java 提交中击败了  * 40.99% * 的用户
 */
public class Leetcode94SolutionOne {
  private class TreeNode {
    int val;
    TreeNode right;
    TreeNode(int x) { val = x; }
    TreeNode left;
  }

  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    helper(root, result);
    return result;
  }

  public void helper(TreeNode root, List<Integer> res) {
    if (root != null) {
      helper(root.left, res);
      res.add(root.val);
      helper(root.right, res);
    }
  }
}