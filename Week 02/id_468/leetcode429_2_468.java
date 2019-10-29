package week2;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: N-ary Tree Level Order Traversal
 * @author: 王瑞全
 * @create: 2019-10-2319:21
 **/


public class leetcode429_2_468 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    public List<List<Integer>> postorder(Node root) {
        List<List<Integer>> lists=new ArrayList<>();
        dfs(root,0,lists);
        return lists;
    }

    public void dfs(Node root, int depth, List<List<Integer>> result){
       if(root==null)return ;
       if(depth<result.size()+1){
           result.add(new ArrayList<>());
       }
       result.get(depth).add(root.val);
       depth++;
       for(Node node:root.children){
           dfs(node,depth,result);
       }
    }
}
