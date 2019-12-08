package com.homework.week2;
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


import java.util.ArrayList;
import java.util.List;

//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x) { val = x; }
//}

public class LeeCode_144_103 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        readPre(root,result);
        return result;
    }

    public void readPre(TreeNode root,List<Integer> result) {
        //条件返回语句
        if (root==null) { return;}
        //执行逻辑
        result.add(root.val);
        readPre(root.left,result);
        readPre(root.right,result);
    }
}
