package com.homework.week2;
//给定一个二叉树，返回它的 后序 遍历。
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
//输出: [3,2,1]
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树

//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x) { val = x; }
//}

import java.util.ArrayList;
import java.util.List;

public class LeeCode_145_103 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        readLast(root,result);
        return result;
    }

    public void readLast(TreeNode root,List<Integer> result) {
        //条件返回
        if (root==null) {return;}
        //逻辑处理
        readLast(root.left,result);
        readLast(root.right,result);
        result.add(root.val);
    }
}
