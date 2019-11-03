//515. 在每个树行中找到最大值

//解法1：BFS
//思路：广度优先遍历, 然后获取每一层ArrayList中的最大值返回即可
//时间复杂度O(n^2) : 获取最大值的方法时间复杂度为O(n)
//空间复杂度O(n)
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
            for (int i = 0; i<size;i++) {

                TreeNode curr = queue.poll();
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
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