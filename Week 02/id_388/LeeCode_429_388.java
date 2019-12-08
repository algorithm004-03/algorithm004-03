package com.company.leetcode.editor.cn;//给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
//
// 例如，给定一个 3叉树 :
//
//
//
//
//
//
//
// 返回其层序遍历:
//
// [
//     [1],
//     [3,2,4],
//     [5,6]
//]
//
//
//
//
// 说明:
//
//
// 树的深度不会超过 1000。
// 树的节点总数不会超过 5000。
// Related Topics 树 广度优先搜索


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node_429.

*/
class Node_429 {
    public int val;
    public List<Node_429> children;

    public Node_429() {}

    public Node_429(int _val,List<Node_429> _children) {
        val = _val;
        children = _children;
    }
}
class Solution_429 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(Node_429 root) {
        //map key记录层级
        helper(root,0);
        return res;
    }
    private void helper(Node_429 Node_429,int index){
        if (Node_429 == null) {
            return;
        }
        List<Integer> tmp = null;
        if (res.size() < (index + 1)) {
            tmp = new ArrayList();
            res.add(tmp);
        }else {
            tmp = res.get(index);
        }
        tmp.add(Node_429.val);
        //children
        if (Node_429.children == null || Node_429.children.size() == 0){
            return;
        }
        for (int i = 0; i < Node_429.children.size(); i++) {
            helper(Node_429.children.get(i),index+1);
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
