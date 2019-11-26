import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};

/*
思路
进行DFS，各层节点被遍历到的时候将自己的数值加入到其层数对应的List中，
节点访问顺序并没有要求要按照其层次顺序进行，没必要进行BFS
 */

class Solution {
    private List<List<Integer>> dfs(List<List<Integer>> result, Node curNode, int level) {
        if (curNode == null) {
            return result;
        }

        if (result.size() < level+1) {
            while (result.size() < level+1) {
                result.add(new LinkedList<>());
            }
        }

        result.get(level).add(curNode.val);
        if (curNode.children != null) {
            for (Node subNode : curNode.children) {
                dfs(result, subNode, level+1);
            }
        }

        return result;
    }


    public List<List<Integer>> levelOrder(Node root) {
        return dfs(new ArrayList<List<Integer>>(1000), root, 0);
    }
}