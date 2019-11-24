import java.util.*;

/**
 * 二叉树的层次遍历
 *
 * 时间复杂度O(n)，空间复杂度O(n)
 *
 *
 */
class Leetcode102SolutionOne {

  private class TreeNode {
    int val;
    int level;
    TreeNode left;
    TreeNode right;

    TreeNode(int x, int l) {
      val = x;
      level = l;
    }

    @Override
    public String toString() {
      return "val = " + val + ", level = " + level;
    }
  }

  List<List<Integer>> result;

  public List<List<Integer>> levelOrder(TreeNode root) {
    result = new ArrayList<>();
    if (root == null) {
      return result;
    }

    bfs(root);
    return result;
  }

  public void bfs(TreeNode root) {
    Deque<TreeNode> queue = new ArrayDeque<>();
    Set<TreeNode> visited = new HashSet<>();
    queue.addLast(root);
    visited.add(root);

    while (!queue.isEmpty()) {
      TreeNode cur = queue.pollFirst();
      visited.add(cur);
      addNodeResult(cur);

      // process cur node
      System.out.println(cur);

      List<TreeNode> children = getChildren(cur);
      for (TreeNode n : children) {
        queue.addLast(n);
      }
    }
  }

  private List<TreeNode> getChildren(TreeNode cur) {
    List<TreeNode> l = new ArrayList<>();
    if (cur.left != null) {
      l.add(cur.left);
    }
    if (cur.right != null) {
      l.add(cur.right);
    }
    return l;
  }

  private void addNodeResult(TreeNode node) {
    if (result.size() <= node.level) {
      Vector<Integer> v = new Vector<>();
      v.add(node.val);
      result.add(v);
    } else {
      Vector<Integer> v = (Vector<Integer>)result.get(node.level);
      v.add(node.val);
    }
  }

  private TreeNode buildTree(Integer[] nums) {
    if (nums == null) {
      return null;
    }

    if (nums.length == 1) {
      return new TreeNode(nums[0], 0);
    }

    List<TreeNode> nodes = new ArrayList<>();
    TreeNode root = new TreeNode(nums[0], 0);
    nodes.add(root);
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == null) {
        continue;
      }

      TreeNode cur = new TreeNode(nums[i], (int) (Math.log(i + 1) / Math.log(2)));
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
    //Integer[] arrayTree = new Integer[]{3, 9, 20, null, null, 15, 7};
    Integer[] arrayTree = new Integer[]{1, 2, 3, 4, null, null, 5};
    Leetcode102SolutionOne solution = new Leetcode102SolutionOne();
    TreeNode root = solution.buildTree(arrayTree);
    System.out.println(solution.levelOrder(root));
  }
}
