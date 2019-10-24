package id_693.practise;

import id_693.TreeNode;

/**
 * @Desc 111. 二叉树的最小深度 https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * @Auther 李雷(KyLin)
 * @Date 2019/10/24
 */
/*
给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

说明: 叶子节点是指没有子节点的节点。

示例:

给定二叉树 [3,9,20,null,null,15,7],

        3
       / \
      9  20
        /  \
       15   7
返回它的最小深度  2.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_111_693 {
    //此题需要注意，****如果还有子节点，那么就还不算叶子节点。那么就会继续找下去***
    //所以相对最大深度，需要考虑这个节点是不是已经到了没有叶子节点的地步，如果下面还有节点，说明还不是叶子节点，还需要找下去

    /*题解
    这道题和maximum depth题正好相反，是求根节点到叶子节点的最小深度，为确保统计的是根节点到叶子节点的深度，
    需要注意：
        当前节点左右子树有一个为空时，返回的应是非空子树的最小深度，而不是空子树深度0；
        若返回0相当于把当前节点认为成叶子节点，与此节点有非空子树矛盾。
        当左右子树都不为空时，和maximum depth题一样，返回左右子树深度的最小值。
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {//如果左节点为null 就找右节点，再加上自己所以 + 1
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {//如果右节点为null 就找左节点，同上
            return minDepth(root.left) + 1;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return Math.min(left, right) + 1;
    }
}
