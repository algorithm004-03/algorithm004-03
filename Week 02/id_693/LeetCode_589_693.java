package id_693;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc 589. N叉树的前序遍历  https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 * @Auther 李雷(KyLin)
 * @Date 2019/10/22
 */
public class LeetCode_589_693 {
    //暴力递归，直接递归中用循环取值
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        recursionConvenience(root,list);
        return list;
    }

    public void recursionConvenience(Node root,List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            for (int i = 0; i < root.children.size(); i++) {
                recursionConvenience(root.children.get(i),list);
            }
        }
    }

    //迭代法，后补
}
