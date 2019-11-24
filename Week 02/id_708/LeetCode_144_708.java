// recursion solution
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        preorder(root, list);
        return list;
    }
    
    private void preorder(TreeNode node, List<Integer> list) {
        if (node == null) return ;
        list.add(node.val);
        preorder(node.left, list);
        preorder(node.right, list);
    }
}

// stack solution
class Solution2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack  = new Stack<>();
        
        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            list.add(curr.val);
            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);
        }
        return list;
    }
}