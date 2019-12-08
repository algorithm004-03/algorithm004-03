//429 N叉树的层序遍历

//解法1：辅助队列迭代法：	执行用时击败约78%
//思路：每次迭代获取当前node的孩子节点, 并将它们依次入队, 按层序遍历的逻辑处理并将结果暂存到temp, 每当该层逻辑处理完毕后在结尾处将temp追加到list
//总结：在学习了层序遍历后, 只要牢记层序遍历模版, 这类题也就驾轻就熟了。
public class NTreeLevelOrderTraversal {
    List<List<Integer>> list = new ArrayList<>(); 
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return list;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size ();
            List<Integer> temp = new ArrayList<>();
            while (size-- > 0) {
                Node curr = queue.poll();
                temp.add(curr.val);
                if (curr.children != null) {
                    for (Node n : curr.children) {
                        queue.offer(n);
                    }
                }
            }
            list.add(temp);
        }
        return list;
    }
}
