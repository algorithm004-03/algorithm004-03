import java.util.*;

/**
 * 429. N叉树的层序遍历
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>       1
 * <p>    / / \
 * <p>   3 2  4
 * <p>  /\
 * <p> 5 6
 * 返回其层序遍历:
 * <p>
 * [
 * [1],
 * [3,2,4],
 * [5,6]
 * ]
 *  
 * <p>
 * 说明:
 * <p>
 * 树的深度不会超过 1000。
 * 树的节点总数不会超过 5000。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jaryoung
 */
public class LeetCode_429_593 {

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Queue<Node> deque = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> nodeList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = deque.poll();
                assert node != null;
                nodeList.add(node.val);
                if (node.children != null) {
                    deque.addAll(node.children);
                }
            }
            result.add(nodeList);
        }
        return result;
    }
}
