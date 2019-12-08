class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int level = 0;
        while(q.isEmpty() == false){
            ans.add(new ArrayList<Integer>());
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode node = q.remove();    
                ans.get(level).add(node.val);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            level++;
        }
        return ans;
    }
}
// Solution {
//     List<List<Integer>> ans = new LinkedList<>();
//     public void dfs(TreeNode root,int depth){
//         List<Integer> temp = new LinkedList<>();
//         if(ans.size() == depth){
//             ans.add(new LinkedList<>());
//         }
//         ans.get(depth).add(root.val);
//         if(root.left != null) dfs(root.left,depth+1);
//         if(root.right != null) dfs(root.right,depth+1);
//     }
//     public List<List<Integer>> levelOrder(TreeNode root) {
//         if(root == null) return ans;
//         dfs(root,0);
//         return ans;
//     }
// }
