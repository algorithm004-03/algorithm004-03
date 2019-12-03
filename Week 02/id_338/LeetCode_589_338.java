package id_338;

import java.util.ArrayList;
import java.util.List;

/**
 * User: liwei
 * Date: 2019/10/24  11:04
 * Desc:
 */
public class LeetCode_589_338 {
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if (root == null) return new ArrayList<>();
        for (int i=0; i<root.children.size(); i++) {
            preorder(root.children.get(i));
        }
        list.add(root.val);
        return list;
    }
}
