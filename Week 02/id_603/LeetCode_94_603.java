import java.util.ArrayList;
import java.util.List;

public class LeetCode_94_603 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public void sorter(TreeNode root,List<Integer> result){
        if (root !=null){
            if (root.left !=null){
                sorter(root.left,result);
            }
            result.add(root.val);
            if (root.right !=null){
                sorter(root.right,result);
            }

        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        sorter(root, res);
        return res;
    }
}
