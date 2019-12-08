import java.util.ArrayList;
import java.util.List;

/**
 * @author northleaf
 * @create 2019年10月30日
 */
public class LeetCode_429_598 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /**
     * 层序遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(root,0,ans);
        return ans;
    }



    private void helper(Node node, int depth, List<List<Integer>> res) {
        //终止条件
        if (node == null) return;
        //判断是否是新的一层
        if (depth + 1 > res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(depth).add(node.val);

        //处理子节点
        for (Node node1 : node.children) {
            if (node1 != null) {
                helper(node1, depth + 1, res);
            }
        }
    }

}
