import java.util.ArrayList;
import java.util.List;

/**
 * Created by leesen on 2019/10/28.
 */
public class LeetCode_102_338 {
    List<List<Integer>> ans = new ArrayList();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        helper(root, 0);
        return ans;
    }

    private void helper(TreeNode root, int level) {
        if (root == null) return;
        if (ans.size() < level + 1) ans.add(level, new ArrayList<Integer>());  //****如果
        ans.get(level).add(root.val);
        ++level;
        if (root.left != null) helper(root.left, level);
        if (root.right != null) helper(root.right, level);
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = new ArrayList();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        ans.get(0).add(1);
        ans.get(0).add(2);
        ans.get(1).add(3);
        System.out.println(ans);
    }
}
