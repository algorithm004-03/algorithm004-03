/**
 * @author northleaf
 * @create 2019年11月21日
 */
public class LeetCode_111_598 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 使用递归的方式处理
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if(root.left == null || root.right == null){
            return Math.max(left,right) +1;
        }
        return Math.min(left,right) + 1;

    }
}
