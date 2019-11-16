//236. 二叉树的最近公共祖先

//解法1：DFS回溯
//思路：判断当前节点curr是否为目标节点P, Q, 若true, 那么另一个目标节点只可能有两种情况:
//					1. 位于当前节点的子树下
//							那么最近公共祖先就为当前节点curr, 但在下结论之前我们也要考虑另一个目标节点是否存在于curr父结点的右子树中
//							若右子树中不存在另一个目标节点, 则可以断定curr节点就是公共祖先
//					2. 另一个祖先节点位于当前节点的父节点的右子树
//		那么我们只需要再reverse回到curr节点的父亲节点, 去判断其右子树中是否存在另一个左右子树即可
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