package id_693;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author 李雷（KyLin）
 * @Desc 236. 二叉树的最近公共祖先	https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * @Date 2019/10/25
 */
public class LeetCode_236_693 {

    //题解：pq不会重复
    /*
        从根节点遍历，递归向左右子树查询节点信息
        递归终止条件：如果当前节点为空或等于p或q，则返回当前节点
        1、递归遍历左右子树，如果左右子树查到节点都不为空，则表明p和q分别在左右子树中，因此，当前节点即为最近公共祖先；
        2、如果左右子树其中一个不为空，则返回非空节点。
     */
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}
