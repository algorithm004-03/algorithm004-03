package id_713;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 构建二叉树
 */
public class LeetCode_105_ConstructBinaryTreeFromPreorderAndInorderTraversal {


    /*
    思路:
    1. 确实需要一个先序遍历的结果, 和一个中序遍历的结果
    2. 先用先序遍历的结果找到root, 然后再去找中序的位置, 位置左边即是左子树, 右边即是右子树
    3. 递归
     */


    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return helper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }


    public TreeNode helper(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {

        if (pStart == pEnd) return null;

        int rootVal = preorder[pStart];
        TreeNode root = new TreeNode(rootVal);

        // 中序遍历找到 根节点索引
        int iRootIndex = 0;
        for (int i = iStart; i < iEnd; i++) {
            if (inorder[i] == rootVal) {
                iRootIndex = i;
                break;
            }
        }


        int leftNum = iRootIndex - iStart;

        root.left = helper(preorder, pStart + 1, pStart + leftNum + 1, inorder, iStart, iRootIndex);
        root.right = helper(preorder, pStart + leftNum + 1, pEnd, inorder, iRootIndex + 1, iEnd);

        return root;
    }


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
