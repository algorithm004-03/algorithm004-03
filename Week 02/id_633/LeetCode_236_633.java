package lesson8;

/**
 * 最近相同祖先问题
 */
public class LeetCode_236_633 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = null;
        lca(root, p, q, lca);
        return lca;
    }
    private boolean lca(TreeNode currentNode, TreeNode p, TreeNode q, TreeNode lca) {

        // terminator 遍历到叶子结点上也没有在当前这根链表上找到p 或 q
        if (currentNode == null)
            return false;

        // process & split subProblems & drill down
        int left = lca(currentNode.left, p, q, lca) ? 1 : 0;

        int right = lca(currentNode.right, p, q, lca) ? 1 : 0;

        int mid = (p == currentNode || q == currentNode) ? 1 : 0;

        if (left + right + mid >= 2)
            lca = currentNode;      // 当前被归回来的结点就是最近祖先结点

        return left + mid + right > 0;  // 左分支 or 右分支 找到了 p 或 q
    }


}
