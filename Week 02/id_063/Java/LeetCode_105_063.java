
class TreeNode {
    int val;
    TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }


/*
思路

进行递归构建，
找出左子树的前序和中序序列，构建左子树
找出右子树的前序和中序序列，构建右子树
左子树的根 右子树的根 和 当前的根节点共同组成新的树

查找子树的前序序列方法:
preorder[0] 一定是当前的根， 在inorder中找preorder[0]的下标x, x 就是左子树中元素的数量，那么preorder[0]后面跟着x个数值就是左子树的前序序列，
preorder再后面的就是右子树的前序序列

查找子树的中序序列的方法:
inorder序列中下标是x的元素就是根，x左边的就是左子树中序序列，x右边就是右子树的中序序列

*/

class Solution {

    private TreeNode buildTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int intEnd) {
        if (preStart == preEnd) {
            return new TreeNode(pre[preStart]);
        }

        int i;
        for (i = inStart; i <= intEnd; i++) {
            if (in[i] == pre[preStart]) {
                break;
            }
        }

        TreeNode leftRoot = null;
        if (i > inStart) {
            leftRoot = buildTree(pre, preStart+1, preStart + (i - inStart),
                                 in, inStart, inStart + (i - inStart) - 1);
        }

        TreeNode rightRoot = null;
        if (i < intEnd) {
            rightRoot = buildTree(pre, preStart + 1 + (i - inStart), preEnd,
                                  in, i + 1, intEnd);
        }

        TreeNode root = new TreeNode(pre[preStart]);
        root.left = leftRoot;
        root.right = rightRoot;

        return root;
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }

        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
}