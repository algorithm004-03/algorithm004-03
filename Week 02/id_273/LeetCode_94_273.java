//94 二叉树的中序遍历

//1. 递归解法	执行用时击败100%
//通过最简单的递归完成左中右的中序遍历
//时间复杂度O(n)
class Solution {
    ArrayList<Integer> arrayList = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            arrayList.add(root.val);
            inorderTraversal(root.right);
        }
        return arrayList;
    }
}

//2. 辅助栈迭代		执行用时击败大约95%
//思路：递归的本质是栈
//时间复杂度O(n)
class Solution {
    List<Integer> arrayList = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode curr = stack.pop();
            arrayList.add(curr.val);
            root = curr.right;
        }
        return arrayList;
    }
}