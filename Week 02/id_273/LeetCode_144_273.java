//144 二叉树前序遍历

//1. 递归解法
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

//2. 辅助栈迭代
//时间复杂度O(n),参考了中序遍历的辅助栈迭代写法，调整了下执行顺序就通过了
class Solution {
    List<Integer> arraylist = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                arraylist.add(current.val);
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            current = current.right;
        }
        return arraylist;
    }
}