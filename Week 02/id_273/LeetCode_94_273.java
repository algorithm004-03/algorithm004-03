//94 二叉树的中序遍历

//1. 递归解法
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

//2. 辅助栈迭代
//递归的本质是栈
//时间复杂度O(n):虽然是两个while循环，但总体上只是迭代获取每个TreeNode的左节点并存入栈
class Solution {
    List<Integer> arrayList = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current!=null || !stack.isEmpty()) {
            while (current!=null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            arrayList.add(current.val);
            current = current.right;
        }
        return arrayList;
    }
}