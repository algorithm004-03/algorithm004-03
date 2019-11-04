package test1.week_2;

/**
 * Created by Administrator on 2019/10/27.
 */
public class Leetcode_226_638 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 反转二叉树
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        helperPreInvert(root);
        return root;
    }

    public  void helperPreInvert(TreeNode root){
        if(root != null){
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            helperPreInvert(root.right);
            helperPreInvert(root.left);

        }
    }
}
