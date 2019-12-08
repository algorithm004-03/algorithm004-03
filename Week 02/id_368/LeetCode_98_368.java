import java.util.ArrayList;
import java.util.List;

public class LeetCode_98_368 {

    /*给定一个二叉树，判断其是否是一个有效的二叉搜索树。
    假设一个二叉搜索树具有如下特征：
    节点的左子树只包含小于当前节点的数。
    节点的右子树只包含大于当前节点的数。
    所有左子树和右子树自身必须也是二叉搜索树。
    链接：https://leetcode-cn.com/problems/validate-binary-search-tree*/

    public static void main(String[] args) {

    }

    List<Integer> res = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        inOrder(root);
        return check(res);
    }

    public boolean isValidBST02 (TreeNode root) {
        return validCheck(root, null, null);
    }

    private boolean validCheck(TreeNode root, Integer minVale, Integer maxValue) {
        if (root == null) return true;
        if ((minVale != null && root.val <= minVale) || (maxValue != null && root.val >= maxValue)) return false;
        return validCheck(root.left, minVale, root.val) && validCheck(root.right, root.val, maxValue);
    }

    public boolean check (List<Integer> res) {
        for (int i = 1; i < res.size(); i++) {
            if (res.get(i) <= res.get(i-1)) {
                return false;
            }
        }
        return true;
    }

    public void inOrder (TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        res.add(root.val);
        inOrder(root.right);
    }
}
