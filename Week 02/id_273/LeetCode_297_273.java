//297. 二叉树的序列化与反序列化

//解法1：利用StringBuild序列化/利用LinkedList反序列化
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = serialize(root, new StringBuilder());
        return res.toString(); 
    }

    private StringBuilder serialize(TreeNode root, StringBuilder str) {
        if (root == null) {
            str.append("null,");
            return str;
        }
        str.append(root.val);
        str.append(",");
        str = serialize(root.left, str);
        str = serialize(root.right, str);
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] temp = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(temp));
        return deserialize(list);
    }

    private TreeNode deserialize(List<String> li) {
        if (li.get(0).equals("null")) {
            li.remove(0);
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(li.get(0)));
        li.remove(0);
        node.left = deserialize(li);
        node.right = deserialize(li);
        return node;
    }
}