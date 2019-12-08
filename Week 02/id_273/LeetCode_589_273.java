//589. N叉树的前序遍历

//解法1：辅助栈迭代法	执行用时击败约35%
//思路：和后序遍历差不多, 按着根--> 左--> 右 的顺序压栈, 并每次pop()一个根节点, 添加到list即可
class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if (root == null) return list;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            list.add(curr.val);
            if (curr.children != null) {
                for (int i = curr.children.size() - 1; i >= 0; i--) {
                    stack.push(curr.children.get(i));
                }
            }
        }
        return list;
    }
}

//解法2：递归实现	执行用时击败100%
//思路：与二叉树的前序遍历递归思路相同, 只是这里需要遍历孩子节点List
class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if (root != null) {
            list.add(root.val);
            for (Node n : root.children) {
                preorder(n);
            }
        }
        return list;
    }
}