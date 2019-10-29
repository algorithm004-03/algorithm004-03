class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new LinkedList<>();
        helper(root, list);
        return list;
    }
    
    private void helper(Node node, List<Integer> list) {
        if (node == null) return ;
        list.add(node.val);
        for (Node child : node.children) {
            helper(child, list);
        }
    }
}

class Solution2 {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            list.add(curr.val);
            for (int i = curr.children.size() - 1; i >= 0; i--) {
                stack.push(curr.children.get(i));
            }
        }
        return list;
    }
}