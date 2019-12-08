package com.company.leetcode.editor.cn;
//根据一棵树的前序遍历与中序遍历构造二叉树。
//
// 注意:
//你可以假设树中没有重复的元素。
//
// 例如，给出
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7]
//
// 返回如下的二叉树：
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// Related Topics 树 深度优先搜索 数组



//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class TreeNode_105 {
    int val;
    TreeNode_105 left;
    TreeNode_105 right;
    TreeNode_105(int x) { val = x; }
}
class Solution_105 {
    private int preIndex = 0;
    private Map<Integer,Integer> valueMap;

    public TreeNode_105 buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        valueMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            valueMap.put(inorder[i],i);
        }

        return helper(0,preorder.length,preorder);
    }

    private TreeNode_105 helper(int startIndex, int endIndex, int[] preorder) {
        if (startIndex >= endIndex) {
            return null;
        }

        TreeNode_105 root = new TreeNode_105(preorder[preIndex]);
        preIndex++;
        int mid = valueMap.get(root.val).intValue();
        root.left = helper(startIndex,mid,preorder);
        root.right = helper(mid + 1,endIndex,preorder);
        return root;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
