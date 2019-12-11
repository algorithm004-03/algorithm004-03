import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 */
public class LeetCode_590_648 {
    ArrayList<Integer> list = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        helper(root);
        return list;
    }
    private void helper(Node node){
        if(node==null){return;}
        List<Node> children = node.children;
        for(int i=0;i<children.size();i++){
            helper(children.get(i));
        }
        list.add(node.val);
    }

    static class Node {
        public int val;
        public List<Node> children;
        public Node() {}
        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };


}
