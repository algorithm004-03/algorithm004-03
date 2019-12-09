import java.util.ArrayList;
import java.util.List;

/**
 * @author eazonshaw
 * @date 2019/10/24  21:32
 * 题目：590. N叉树的后序遍历
 * 描述：给定一个 N 叉树，返回其节点值的后序遍历。
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 */
public class LeetCode_590_243 {

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        post(list,root);
        return list;
    }
    //递归函数
    private void post(List<Integer> list,Node root){
        if(root==null)return;
        for(Node node:root.children){
            post(list,node);
        }
        list.add(root.val);
    }

}
