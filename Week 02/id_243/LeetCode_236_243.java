/**
 * @author eazonshaw
 * @date 2019/10/27  17:26
 * 题目：236. 二叉树的最近公共祖先
 *
 * 描述：给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LeetCode_236_243 {

    //公共变量
    private TreeNode tn = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recur(root,p,q);
        return tn;
    }

    //递归函数
    private boolean recur(TreeNode root, TreeNode p, TreeNode q){
        //终止条件
        if(root == null) return false;

        //判断左边是否含有p，q节点
        int left = recur(root.left,p,q)?1:0;

        //判断右边是否含有p，q节点
        int right = recur(root.right,p,q)?1:0;

        //判断是否为当前节点
        int mid = (root == p||root == q)?1:0;

        //判断当前的树是否已经包含了两个节点
        //这里是核心代码
        if(left + right + mid >=2){
            tn = root;
        }

        //只要含有两个节点则返回真
        return left + right + mid >0;
    }


}
