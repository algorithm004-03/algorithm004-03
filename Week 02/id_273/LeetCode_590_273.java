//590. N叉树的后序遍历

//解法1：递归法
//每递归到叶子节点 list.add
//提交时由于内存耗尽因此不可取
class Solution {
	List<Integer> list = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        if (root != null) {
            for (int i = 0;i<root.children.size();i++) {
                postorder(root.children.get(i));
            }
            list.add(root.val);
        }
        return list;
    }
}

//解法2：辅助栈迭代法
//通过前序遍历获取，list.add按逆序存储
//push孩子结点的顺序也和前序遍历相反
class Solution {
    List<Integer> list = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        if (root == null) return list; 
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            list.add(0, current.val);
            if  (current.children != null) {
                for (Node n : current.children) {
                    stack.push(n);
                }
            }
        }
        return list;
    }
}