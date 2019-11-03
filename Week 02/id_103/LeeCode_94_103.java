package com.homework.week2;

import java.util.ArrayList;
import java.util.List;

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


//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x) { val = x; }
//}

public class LeeCode_94_103 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        readMid(root,list);
        return list;
    }

    public void readMid(TreeNode root,List<Integer> list){
        //条件语句
        if (root==null) {
            return;
        }
        //执行逻辑
        readMid(root.left,list);
        list.add(root.val);
        readMid(root.right,list);
    }
}
