import java.util.ArrayList;
import java.util.List;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class LeetCode_144_548 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<> ();
        helper(root, list);
        return list;
    }

    public void helper(TreeNode node, List<Integer> res) {
        if (node != null) {
            res.add(node.val);
            helper(node.left, res);
            helper(node.right, res);
        }
    }

}


