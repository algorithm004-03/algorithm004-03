//590. N叉树的后序遍历

//解法1：递归法		执行用时击败100%
//思路：深度优先遍历思想
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

//解法2：辅助栈迭代法	执行用时击败约30%
//思路：N叉树的后序遍历为左->中->右->根, 那么只需要不断从当前的node.right进行深度优先遍历, 每次压栈时把当前node.val存放到list头部即可, 这样逆序存放可以使"根-->右-->中-->左"的遍历顺序得到"左->中->右->根"的结果
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