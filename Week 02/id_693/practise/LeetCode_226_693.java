package id_693.practise;

import id_693.TreeNode;

/**
 * @Desc 226. 翻转二叉树  https://leetcode-cn.com/problems/invert-binary-tree/description/
 * @Auther 李雷(KyLin)
 * @Date 2019/10/24
 */
/*

翻转一棵二叉树。

示例：

输入：

         4
       /   \
      2     7
     / \   / \
    1   3 6   9
输出：

         4
       /   \
      7     2
     / \   / \
    9   6 3   1
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/invert-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_226_693 {
    //标准递归，元素互换
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
