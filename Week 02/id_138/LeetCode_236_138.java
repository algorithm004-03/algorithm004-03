/**
 * 二叉树的最近公共祖先
 * @author L
 *
 */
public class LeetCode_236_138 {
	
	private TreeNode ancestor = null;
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findLowestAncestor(root, p, q);
        return ancestor;
    }
	/**
	 *  从pre节点向下寻找是否存在子节点p和q
	 * @param pre
	 * @param p
	 * @param q
	 * @return
	 */
	private boolean findLowestAncestor(TreeNode pre, TreeNode p, TreeNode q) {
		//没有找到
		if(pre == null)
			return false;
		//左子树递归，如果返回true则设置left=1
		int left = findLowestAncestor(pre.left, p, q)?1:0;
		//右子树递归，如果返回true则设置right=1
		int right = findLowestAncestor(pre.right, p, q)?1:0;
		
		int mid = (pre == p || pre == q)?1:0;
		
		int sum = mid+left+right;
		if(sum >= 2) {//当前pre就是最近祖先节点
			this.ancestor = pre;
		}
		return sum>0;//当前pre是p或者q的祖先
		
	}
	
}
