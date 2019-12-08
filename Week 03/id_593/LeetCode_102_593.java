
/**
 * 102. 二叉树的层次遍历
 *
 * <p>
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * <p>     3
 * <p>    / \
 * <p>   9  20
 * <p>     /  \
 * <p>    15   7
 * <p> 返回其层次遍历结果：
 * <p>
 * <p> [
 * <p>   [3],
 * <p>   [9,20],
 * <p>   [15,7]
 * <p> ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jaryoung
 * @version 1.0 实现两种思路 DFS 和 BFS
 */
public class LeetCode_102_593 {

    /**
     * 通过 广度优先搜索 遍历树
     *
     * @param root 目标树
     * @return 遍历后的数组
     */
    public List<List<Integer>> levelOrderBfs(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        deque.addFirst(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode current = deque.poll();
                assert current != null;
                if (!visited.contains(current)) {
                    visited.add(current);
                    list.add(current.val);
                }
                if (current.left != null) {
                    deque.addLast(current.left);
                }
                if (current.right != null) {
                    deque.addLast(current.right);
                }
            }
            result.add(list);
        }
        return result;
    }


    public List<List<Integer>> levelOrderByDfs(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        levelOrderByDfs(root, 0, result);
        return result;
    }

    private void levelOrderByDfs(TreeNode root, int level, List<List<Integer>> result) {
        // terminator
        if (root == null) {
            return;
        }
        // process
        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        // drill down
        if (root.left != null) {
            levelOrderByDfs(root.left, level + 1, result);
        }
        if (root.right != null) {
            levelOrderByDfs(root.right, level + 1, result);
        }
    }


}