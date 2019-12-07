import java.util.ArrayList;
import java.util.List;

/**
 * 判断是否二叉搜索树
 *
 * 中序遍历，然后判断中序遍历的数组是否有序
 *
 * 时间复杂度O(n)(2n，要遍历2遍)，空间复杂度O(n)
 *
 * 执行用时 : * 3 ms * , 在所有 java 提交中击败了 * 42.51% * 的用户
 * 内存消耗 : * 37.1 MB * , 在所有 java 提交中击败了 * 86.85% * 的用户
 */
public class Leetcode98SolutionOne {
  private class TreeNode {
    int val;
    TreeNode right;
    TreeNode(int x) { val = x; }
    TreeNode left;
  }

  public boolean isValidBST(TreeNode root) {
    List<Integer> inorderList = inorderTraversal(root);
    if (inorderList.isEmpty()) {
      return true;
    }

    int lastVal = inorderList.get(0);
    for (int i = 1; i < inorderList.size(); i++) {
      if (inorderList.get(i) <= lastVal) {
        return false;
      }

      lastVal = inorderList.get(i);
    }

    return true;
  }

  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
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