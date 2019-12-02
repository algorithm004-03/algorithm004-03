import java.util.Arrays;
import java.util.LinkedList;

public class LeetCode_297_368 {

    /*序列化是将一个数据结构或者对象转换为连续的比特位的操作，
    进而可以将转换后的数据存储在一个文件或者内存中，
    同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
    请设计一个算法来实现二叉树的序列化与反序列化。
    这里不限定你的序列 / 反序列化算法执行逻辑，
    你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
    链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree*/


    public static void main(String[] args) {

    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder s = new StringBuilder();
        buildString(root, s);
        return s.toString();
    }

    private void buildString(TreeNode root, StringBuilder s) {
        if (root == null) {
            s.append("#").append(",");
        } else {
            s.append(root.val).append(",");
            buildString(root.left, s);
            buildString(root.right, s);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(",")));
        return buildTree(nodes);
    }

    private TreeNode buildTree(LinkedList<String> nodes) {
        String s = nodes.removeFirst();
        if ("#".equals(s)) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.valueOf(s));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
}
