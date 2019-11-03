package com.code.week02;


import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 *
 * 例如，给定一个 3叉树 :
 * 返回其前序遍历: [1,3,5,6,2,4]。
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_589_748_preorder {


    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root,res);
        return res;
    }

    private void helper(Node root, List<Integer> res) {

        if(root != null){
            res.add(root.val);
            for(Node node : root.children){
                helper(node,res);
            }
        }
    }

}
