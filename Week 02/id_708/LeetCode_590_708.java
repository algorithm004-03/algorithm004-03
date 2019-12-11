class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new LinkedList<>();
        helper(root, list);
        return list;
    }
     
    private void helper(Node node, List<Integer> list) {
        if (node == null) return ;
        for (Node child : node.children) {
            helper(child, list);
        }
        list.add(node.val);
    }
}

class Solution2 {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new LinkedList<>();
        helper(root, list);
        return list;
    }
     
    private void helper(Node node, List<Integer> list) {
        if (node == null) return ;
        for (Node child : node.children) {
            helper(child, list);
        }
        list.add(node.val);
    }
}