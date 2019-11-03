import java.util.List;

/**
 * @author eazonshaw
 * @date 2019/10/24  21:33
 *
 * N叉树的节点类
 */
public class Node {

    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}
