package id_693;

import java.util.Arrays;

/**
 * @Author 李雷（KyLin）
 * @Desc
 * @Date 2019/10/25
 */
public class LeetCode_105_693 {
    //题解
    /*
        3
       / \
      9  20
        /  \
       15   7
    1、根据前序遍历，找到root节点
    2、根据前序遍历的root节点 到 中序遍历中区分左右节点，并构建相应的数。
    */
    public TreeNode buildTree(int[] preorder,int[] inorder) {
        return build(preorder,0,inorder,0,inorder.length);
    }

    /**
     * @param preorder 前序数组
     * @param preStart 起始坐标，（）
     * @param inorder
     * @param inStart
     * @param inEnd
     * @return
     * @desc1 preStart + 1 在前序数组原头节点的下一个索引位置，同时也是原头节点的左子树节点
     * @desc2 leftTreeSize左树长度（用于计算右子树的头索引，右子树的索引为： preStart + 1 + leftTreeSize）
     */
    private TreeNode build(int[] preorder,int preStart,int[] inorder,int inStart,int inEnd) {
        if (inStart >= inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inHead = inStart;
        while (inorder[inHead] != root.val) {
            inHead++;
        }
        int leftTreeSize = inHead - inStart;
        root.left = build(preorder,preStart + 1,inorder,inStart,inHead);
        root.right = build(preorder,preStart + 1 + leftTreeSize,inorder,inHead + 1,inEnd);
        return root;
    }

    public static void main(String[] args) {
        new LeetCode_105_693().buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
    }
}
