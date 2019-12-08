class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        TreeNode cur=root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null) {
                ans.add(cur.val);
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.pop();
            cur=cur.right;
        }
        return ans;
    }
}
// class Solution {
//     public List<Integer> preorderTraversal(TreeNode root) {
//         List<Integer> ans = new ArrayList<>();
//         a(root,ans);
//         return ans;
//     }
//     public void a(TreeNode root , List<Integer> ans){
//         if(root != null){
//             ans.add(root.val);
//             if(root.left != null) a(root.left , ans);
//             if(root.right != null) a(root.right , ans );
//         }
//     }
// }
