package com.code.week02;


import java.util.ArrayList;
import java.util.List;

/***
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 * 返回其后序遍历: [5,6,3,2,4,1].
 *
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_590_748_postorder {


    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root,res);
        return res;
    }


    public void helper(Node root, List<Integer> res){
        if(root != null){
            // root存在子节点，先解决子节点
            for(Node node : root.children){
                helper(node,res);
            }
            // 最后添加根节点
            res.add(root.val);
        }
    }


}


class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};