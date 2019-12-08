public class LeetCode_105_368 {

    /*根据一棵树的前序遍历与中序遍历构造二叉树。
    注意: 你可以假设树中没有重复的元素。
    https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/*/

    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) return null;
        return build(preorder, 0, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preLeft, int[] inorder, int inLeft, int inRight) {
        // terminator
        if (inLeft > inRight) {
            return null;
        }
        // process current logic
        TreeNode root = new TreeNode(preorder[preLeft]);
        int k = inLeft;
        while (inorder[k] != root.val) {
            k++;
        }
        root.left = build(preorder, preLeft + 1, inorder, inLeft, k - 1);
        root.right = build(preorder, preLeft + k - inLeft + 1, inorder, k + 1, inRight);
        return root;
    }
}
