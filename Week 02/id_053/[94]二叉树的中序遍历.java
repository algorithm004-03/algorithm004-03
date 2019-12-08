//给定一个二叉树，返回它的中序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表



//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        process(root,result);
        return result;
    }
    public void process(TreeNode root,List<Integer> result) {
    	if (root != null) {
			if (root.left != null) {
				process(root.left,result);
			}
			result.add(root.val);
			if (root.right != null) {
				process(root.right,result);
			}
		}
	}
}
//class TreeNode{
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode(int val){
//        this.val = val;
//        this.left = null;
//        this.right = null;
//    }
//		}
//leetcode submit region end(Prohibit modification and deletion)
