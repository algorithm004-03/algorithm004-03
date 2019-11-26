package id_338;

import java.util.ArrayList;
import java.util.List;

/**
 * N叉树的后序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 */
public class LeetCode_590_338 {
    List<Integer> list = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if (root == null) return new ArrayList<>();
        for (int i=0; i<root.children.size(); i++) {
            postorder(root.children.get(i));
        }
        list.add(root.val);
        return list;
    }
}
