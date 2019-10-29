class Solution {
    private TreeNode ans;
    private boolean helper(TreeNode root, TreeNode p ,TreeNode q){
        if(root == null) return false;
        int left = this.helper(root.left,p,q) == true ? 1 :0;
        int right = this.helper(root.right,p,q) == true?1 : 0;
        int mid = (root == p || root == q) ? 1:0;
        if(left + right + mid>=2)  {ans=root;}
        if(left + right + mid>0) return true;
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.helper(root ,p,q);
        return this.ans;
    }
}
