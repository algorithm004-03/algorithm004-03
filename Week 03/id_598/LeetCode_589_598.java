import org.omg.CORBA.NO_IMPLEMENT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author northleaf
 * @create 2019年10月30日
 */
public class LeetCode_589_598 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /**
     * 前序遍历：根左右
     *  递归写法
     * @param root
     * @return
     */
    public List<Integer> preorder1(Node root) {
        List<Integer> list = new ArrayList<>();
        preorder(root,list);
        return list;
    }

    /**
     * 前序遍历
     * @param node
     * @param list
     */
    private void preorder(Node node, List<Integer> list) {
        if (node != null) {
            list.add(node.val);
            if(node.children!=null){
                for(Node n:node.children){
                    preorder(n,list);
                }
            }

        }
    }

    /**
     * 前序遍历 概左右
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node tmp = stack.pop();
            list.add(tmp.val);
            List<Node> tmpList = tmp.children;
            Collections.reverse(tmpList);
            for(Node n:tmpList){
                stack.push(n);
            }
        }
        return list;
    }

}
