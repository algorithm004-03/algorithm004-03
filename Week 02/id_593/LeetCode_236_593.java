/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * <p>        3
 * <p>      /   \
 * <p>     5    1
 * <p>    / \  / \
 * <p>   6  2  0 8
 * <p>     / \
 * <p>    7  4
 * 示例 1:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jaryoung
 */
public class LeetCode_236_593 {

    TreeNode result;

    /**
     * 通过 递归 查询 找到二叉树中两个指定节点的最近公共祖先
     *
     * @param root 根节点
     * @param p    p结点
     * @param q    q结点
     * @return 最近的公共祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        result = null;
        recursion(root, p, q);
        return result;
    }

    public int recursion(TreeNode root, TreeNode p, TreeNode q) {
        // terminator
        if (root == null) {
            return 0;
        }
        // process ,drill down
        int left = recursion(root.left, p, q);
        int right = recursion(root.right, p, q);

        // 看是否已经找到 p 或者 q的结点
        int mid = root == p || root == q ? 1 : 0;
        // 大于1的时候，说明已经找到了p 和 q的结点 ，并且当前结点就是我们要找的最近的祖先结点
        if (mid + left + right > 1) {
            result = root;
        }
        return mid + left + right > 0 ? 1 : 0;
    }
}