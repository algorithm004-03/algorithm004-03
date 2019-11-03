import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode_429_368 {

    /*给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
    https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/*/

    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> currList = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node node = queue.poll();
                currList.add(node.val);
                for (Node no : node.children) {
                    queue.offer(no);
                }
            }
            res.add(currList);
        }
        return res;
    }
}
