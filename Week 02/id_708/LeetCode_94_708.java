// recursion solution
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();   
        inorder(root, list);
        return list;
    }
    
    private void inorder(TreeNode node, List<Integer> list) {
        if (node == null) return ;
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }
}

// stack solution
class Solution2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();   
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            // push all left elements
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right; // curr can not be the element at stack again
        }
        return list;
    }
}