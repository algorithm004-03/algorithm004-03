package id_693.practise;

import id_693.TreeNode;

/**
 * @Desc 98. 验证二叉搜索树   https://leetcode-cn.com/problems/validate-binary-search-tree/
 * @Auther 李雷(KyLin)
 * @Date 2019/10/24
 */
/*
给定一个二叉树，判断其是否是一个有效的二叉搜索树。

假设一个二叉搜索树具有如下特征：

节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
示例 1:

    输入:
        2
       / \
      1   3
    输出: true
示例 2:

    输入:
        5
       / \
      1   4
         / \
        3   6
    输出: false
    解释: 输入为: [5,1,4,null,null,3,6]。
         根节点的值为 5 ，但是其右子节点值为 4 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/validate-binary-search-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_98_693 {
    //递归法
    //利用lower保存左边上一个数字，upper保存右边上一个数字
    public boolean isValidBST(TreeNode root) {
        return search(root, null, null);
    }

    public boolean search(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }
        int temp = root.val;
        if (lower != null && temp >= lower) {
            return false;
        }
        if (upper != null && temp <= upper) {
            return false;
        }
        if (root.left != null && !search(root.left, temp, upper)) {
            return false;
        }
        if (root.right != null && !search(root.right, lower, temp)) {
            return false;
        }
        return true;
    }

    //递归法-代码优化
    public boolean isValidBST2(TreeNode root) {
        return search(root, null, null);
    }

    public boolean search2(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }
        int temp = root.val;
        if (lower != null && temp >= lower) {
            return false;
        }
        if (upper != null && temp <= upper) {
            return false;
        }
        if (!search(root.left, temp, upper) || !search(root.right, lower, temp)) {
            return false;
        }
        return true;
    }

}
