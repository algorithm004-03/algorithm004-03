package id_693;

import java.util.List;

/**
 * @Desc
 * @Auther 李雷(KyLin)
 * @Date 2019/10/22
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
