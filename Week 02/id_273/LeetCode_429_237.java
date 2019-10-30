//429 N叉树的层序遍历

//解法1:辅助队列迭代法：
//依次获取每一层的node并存放至队列，出队时将值添加到ArrayList中
public class NTreeLevelOrderTraversal {
    List<List<Integer>> list = new ArrayList<>();
	
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return list;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> temp = new ArrayList<>();
            while (count-- > 0) {
                Node current = queue.poll();
                temp.add(current.val);
                for(Node node:current.children) {
                    if (node != null) {
                       queue.add(node);
                    }
                }
            }
            list.add(temp);
        }
        return list;
    }
}
