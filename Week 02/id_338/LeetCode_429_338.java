package id_338;

import java.util.ArrayList;
import java.util.List;

/**
 * User: liwei
 * Date: 2019/10/24  09:51
 * Desc:
 */
public class LeetCode_429_338 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return new ArrayList<>();
        help(root, 0, res);
        return res;
    }

    private void help (Node root, int depth, List<List<Integer>> res) {
        //退出条件
        if (root == null) return;
        //判断是否是新的一层
        if (res.size() < depth + 1) {
            res.add(new ArrayList<Integer>());
        }
        res.get(depth).add(root.val);
        //处理子节点
        for (Node node : root.children) {
            if (node != null) {  //空节点判断别遗漏
                help(node, depth+1, res);
            }
        }
    }
}