import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author northleaf
 * @create 2019年10月30日
 */
public class LeetCode_590_598 {
    public class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /**
     * 后序遍历:左右根
     * @param root
     * @return
     */
    public List<Integer> postorder1(Node root) {
        List<Integer> list = new ArrayList<>();
        postorder(root,list);
        return list;

    }

    /**
     * 递归遍历
     * @param node
     * @param list
     */
    private void postorder(Node node, List<Integer> list) {
        //终止条件
        if (node == null) {
            return;
        }

        //处理当前层数据
        if(node.children!=null) {
            for (Node n : node.children) {
                postorder(n,list);
            }
        }
        list.add(node.val);

    }

    /**
     * 后序遍历：左右根
     *  非递归
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            //反向添加
            output.addFirst(node.val);
            for (Node item : node.children) {
                if (item != null) {
                    stack.add(item);
                }
            }
        }
        return output;
    }
}
