import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树，max depth
 * <p>
 * 采用递归，时间复杂度O(logN)，空间复杂度O(1)
 */
class LeetcodeMaxDepthSolutionOne {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  private int maxDepth;

  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    this.maxDepth = 0;
    _helper(root, 1);
    return this.maxDepth;
  }

  private void _helper(TreeNode root, int depth) {
    if (root == null) {
      return;
    }

    this.maxDepth = this.maxDepth < depth ? depth : this.maxDepth;

    if (root.left != null) {
      _helper(root.left, depth + 1);
    }

    if (root.right != null) {
      _helper(root.right, depth + 1);
    }
  }

  private TreeNode buildTree(Integer[] nums) {
    if (nums == null) {
      return null;
    }

    if (nums.length == 1) {
      return new TreeNode(nums[0]);
    }

    List<TreeNode> nodes = new ArrayList<>();
    TreeNode root = new TreeNode(nums[0]);
    nodes.add(root);
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == null) {
        continue;
      }

      TreeNode cur = new TreeNode(nums[i]);
      nodes.add(cur);
      if (i % 2 == 0) {
        nodes.get(i / 2 - 1).right = cur;
      } else {
        nodes.get(i / 2).left = cur;
      }
    }

    return root;
  }

  public static void main(String[] args) {
    Integer[] arrayTree = new Integer[]{3, 9, 20, null, null, 15, 7};
    LeetcodeMaxDepthSolutionOne solution = new LeetcodeMaxDepthSolutionOne();
    TreeNode root = solution.buildTree(arrayTree);
    System.out.println(solution.maxDepth(root));
  }
}
