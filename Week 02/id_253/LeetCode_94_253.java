class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        TreeNode cur=root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur=cur.left;
            }
            cur = stack.pop();
            ans.add(cur.val);
            cur=cur.right;
        }
        return ans;
    }
}
// class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> ans = new ArrayList<>();
//         a(root , ans);
//         return ans;
//     }
//     public void a(TreeNode root , List<Integer> ans){
//         if(root != null){
//             if(root.left != null) a(root.left , ans);
//             ans.add(root.val);
//             if(root.right !=null) a(root.right , ans);
//         }
        
//     }
// }
