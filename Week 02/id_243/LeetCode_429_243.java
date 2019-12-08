import java.util.ArrayList;
import java.util.List;

/**
 * @author eazonshaw
 * @date 2019/10/27  11:48
 * 题目：429. N叉树的层序遍历
 * 描述：给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 */
public class LeetCode_429_243 {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        order(root,0,list);
        return list;
    }

    //递归函数
    private void order(Node root,Integer depth,List<List<Integer>> list){
        if(root==null) return;
        //判断是否为新的一层
        if(depth + 1 >list.size()){
            list.add(new ArrayList<>());
        }
        list.get(depth).add(root.val);

        //处理子节点
        for(Node node:root.children){
            order(node,depth+1,list);
        }
    }

}
