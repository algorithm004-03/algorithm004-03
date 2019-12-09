package week2;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: N叉树的后序遍历
 * @author: 王瑞全
 * @create: 2019-10-2318:56
 **/


public class leetcode590_2_468 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    public List<Integer> postorder(Node root) {
        List<Integer> list=new ArrayList<>();
        return solve(root,list);
    }

    public List<Integer> solve(Node root,List<Integer> list){
        if(root==null)return list;
        List<Node> childs=root.children;
        for(Node node:childs){
           solve(node,list);
        }
        list.add(root.val);
        return list;
    }
}
