//589. N叉树的前序遍历

//解法1：辅助栈迭代法
//由于递归无法通过这里就不写了
//和后序遍历差不多，只是栈存放孩子结点时的顺序稍微改下，list.add按着顺序添加行
class Solution {
    List<Integer> list = new ArrayList<>();
    
    public List<Integer> preorder(Node root) {
        if (root == null) return list;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            list.add(current.val);
            if (current.children != null) {
               for(int i = current.children.size()-1;i>=0;i--) {
                   stack.push(current.children.get(i));
               }
            }
        }
        return list;
    }
}