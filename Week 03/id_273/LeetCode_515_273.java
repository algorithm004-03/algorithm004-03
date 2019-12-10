//515. 在每个树行中找到最大值

//解法1：BFS	执行用时击败约40%
//思路：广度优先遍历, 然后获取每一层ArrayList中的最大值返回即可
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        queue.offer(root);
        while (!queue.isEmpty()) {
            //获取当前层的node数
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size;i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
                temp.add(curr.val);
            }
            result.add(getMax(temp));
        }
        return result;
    }

    private int getMax(List<Integer> list) {
        int max = Integer.MIN_VALUE;
        for (int i : list) {
            if (max < i) {
                max = i;
            }
        }
        return max;
    }
}

//解法2：DFS	执行用时击败约100%
//思路：深度优先遍历, 用一个level记录当前层数, 遍历所有节点, 在放入result数组之前与result数组中"对应当前递归level的索引下的元素"比较大小
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);        
        return result;
    }

    private void dfs(TreeNode node, int level, List<Integer> list) {
        if (node == null) return;
        if (level == list.size()) list.add(node.val);
        else list.set(level, Math.max(list.get(level), node.val));
        dfs(node.left, level + 1, list);
        dfs(node.right, level + 1, list);
    }
}