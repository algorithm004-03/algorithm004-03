//297. 二叉树的序列化与反序列化

//解法1：DFS递归解法		执行用时击败约88%
public class Codec {
	//序列化
    public String serialize(TreeNode root) {
       StringBuilder sb = new StringBuilder();
       return recur(sb, root).toString();
    }
    private StringBuilder recur(StringBuilder sb, TreeNode root) {
         if (root == null) {
            sb.append("null,");
            return sb;
        }
		//小细节：逗号和root.val分开append, 是因为','可以从常量池中直接获取, 不必再次新建字符串。
        sb.append(root.val);
		sb.append(",");
        recur(sb, root.left);
        recur(sb, root.right);
        return sb;
    }
	
	//反序列化
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        String[] values = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(values));
        return recurDe(list);
    }
    private TreeNode recurDe(List<String> list) {
        if (list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }
        TreeNode curr = new TreeNode(Integer.valueOf(list.remove(0)));
        curr.left = recurDe(list);
        curr.right = recurDe(list);
        return curr;
    }
}

//解法2：BFS解法		执行用时击败61%
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == null) {
                sb.append("null,");
                continue;
            }
            sb.append(curr.val+",");
            queue.offer(curr.left);
            queue.offer(curr.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") return null;
        Queue<TreeNode> queue = new LinkedList<>();
        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.offer(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = queue.poll();
            if (!values[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                queue.offer(left);
            }
            if (!values[++i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                queue.offer(right);
            }
        }
        return root;
    }
}