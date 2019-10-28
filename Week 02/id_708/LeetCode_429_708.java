// BSF
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        
        if (root != null) queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currList = new LinkedList<>();
            while (size-- > 0) {
                Node curr = queue.remove();
                currList.add(curr.val);
                for (Node child : curr.children) {
                    queue.offer(child);
                }
            }
            list.add(currList);
        }
        return list;
    }
}