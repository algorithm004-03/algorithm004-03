//144 二叉树前序遍历

//1. 递归解法		执行用时击败100%
//时间复杂度O(n)
class Solution {
    List<Integer> arraylist = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null) {
            arraylist.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return arraylist;
    }
}

//2. 辅助栈迭代		执行用时击败93%
//时间复杂度O(n)
class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                list.add(root.val);
                root = root.left;
            }
            TreeNode curr = stack.pop();
            root = curr.right;
        }
        return list;
    }
}