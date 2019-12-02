//思路：这个题目主要利用了ArrayList可以根据下标获取存储在数组中的元素，
//在每一层建立一个数组是这个题目的关键步骤。
class LevelOrder {
    List<List<Integer>> levels  = new ArrayList();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return levels;
        helper(root, 0);
        return levels;
    }
    public void helper(TreeNode root,int level) {   
        if (levels.size() == level) 
            levels.add(new ArrayList<Integer>());
            levels.get(level).add(root.val);
        if (root.left != null) 
            helper(root.left, level + 1);
        if (root.right != null) 
            helper(root.right, level + 1);
    }
} 