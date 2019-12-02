import java.util.LinkedList;
import java.util.List;

/*
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

/*
思路
简单递归前序遍历
*/

public class Solution {
    private List<Integer> dfs(List<Integer> result, Node curNode) {
        if (curNode == null) {
            return result;
        }

        result.add(curNode.val);
        if (curNode.children != null) {
            for (Node subNode : curNode.children) {
                dfs(result, subNode);
            }
        }

        return result;
    }

    public List<Integer> preorder(Node root) {
        return dfs(new LinkedList<Integer>(), root);
    }
}