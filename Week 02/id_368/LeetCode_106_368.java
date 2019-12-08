/**
 * @author: liuyanhui@daojia-inc.com
 * @date: 2019/11/1
 */
public class LeetCode_106_368 {

    /*
    根据一棵树的中序遍历与后序遍历构造二叉树。
    你可以假设树中没有重复的元素。
    https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
    */

    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length) {
            return null;
        }
        return build(inorder, 0, inorder.length - 1, postorder, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int inLeft, int inRight, int[] postorder, int postRight) {
        if (inLeft > inRight) {
            return null;
        }
        int k = inLeft;
        while (inorder[k] != postorder[postRight]) {
            k++;
        }
        TreeNode root = new TreeNode(postorder[postRight]);
        root.left = build(inorder, 0, k - 1, postorder, postRight - inRight + k - 1);
        root.right = build(inorder, k + 1, inRight, postorder, postRight - 1);
        return root;
    }
}
