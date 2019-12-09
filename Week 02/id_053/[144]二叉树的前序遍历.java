//给定一个二叉树，返回它的 前序 遍历。 
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
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树



//leetcode submit region begin(Prohibit modification and deletion)
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        recursionTask(root,result);
        return result;
    }
    private void recursionTask(TreeNode root,List<Integer> result) {
    	//前序遍历，根左右
        if (root != null) {
            result.add(root.val);
            if (root.left != null) {
                recursionTask(root.left,result);
            }
            if (root.right != null ) {
                recursionTask(root.right,result);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
