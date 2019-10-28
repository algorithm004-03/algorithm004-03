//236. 二叉树的最近公共祖先

//解法1：回溯
//思路：	当 p 或 q 其中有一个等于currentNode, 则说明currentNode自己为最近公共祖先
//				terminate：root == p or q , return root
//			若currNode != q or q ,递归左右子树寻找p and q,
//			若在左右子树都没有找到目标节点,return null到到上一层递归
//			若在左,右子树只找到了一个目标节点,return 目标节点到上一层递归
//			
//			若在左,右子树分别找到了两个目标节点,说明其父结点currNode是最近公共祖先,return currNode
//时间复杂度O(n)
//空间复杂度O(n)
class Solution {
   public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == q || root == p) return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }
}