package com.company.leetcode.editor.cn;//给定一个 N 叉树，返回其节点值的后序遍历。
//
// 例如，给定一个 3叉树 :
//
//
//
//
//
//
//
// 返回其后序遍历: [5,6,3,2,4,1].
//
//
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node_590.

*/
class Node_590 {
    public int val;
    public List<Node_590> children;

    public Node_590() {}

    public Node_590(int _val,List<Node_590> _children) {
        val = _val;
        children = _children;
    }
}
class Solution_590 {
    List<Integer> res = new ArrayList<>();

    //递归写法
    public List<Integer> postorder(Node_590 root) {
        helper(root);
        return res;
    }

    //按模板后序遍历
    private void helper(Node_590 Node_590){
        if (Node_590 == null) {
            return;
        }

        if (Node_590.children == null) {
            res.add(Node_590.val);
            return;
        }

        for (int i = 0; i < Node_590.children.size(); i++) {
            Node_590 tmp = Node_590.children.get(i);
            helper(tmp);
        }

        res.add(Node_590.val);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
