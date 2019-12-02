
/**
 * 从前序与中序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class LeetCode_105_588 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return _buildHelper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode _buildHelper(int[] preorder, int pStart, int pEnd, int[] inorder, int inStart, int inEnd) {
        if (pStart == pEnd) {
            return null;
        }

        int rootValue = preorder[pStart];
        TreeNode root = new TreeNode(rootValue);
        int rootIndexInInOrder = 0;
        for (int i = inStart; i < inEnd; i++) {
            if (rootValue == inorder[i]) {
                rootIndexInInOrder = i;
                break;
            }
        }
        int leftNum = rootIndexInInOrder - inStart;
        root.left = _buildHelper(preorder, pStart + 1, pStart + leftNum + 1, inorder, inStart, rootIndexInInOrder);
        root.right = _buildHelper(preorder, pStart + leftNum + 1, pEnd, inorder, rootIndexInInOrder + 1, inEnd);
        return root;
    }


    public static void main(String[] args) {

        int[] preOrder = {3,9,20,15,7};
        int[] inOrder = {9,3,15,20,7};
        LeetCode_105_588 solution = new LeetCode_105_588();
        solution.buildTree(preOrder, inOrder);
    }
}
