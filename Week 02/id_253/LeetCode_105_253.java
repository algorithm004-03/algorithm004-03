class Solution {
    int pre_idx=0;
    int[] preorder;
    int[] inorder;
    HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    public TreeNode helper(int left ,int right){
        if(left == right) return null;
        int pre = preorder[pre_idx];
        TreeNode root = new TreeNode(pre);
        pre_idx++;
        int index= map.get(pre);
        root.left=helper(left,index);
        root.right=helper(index+1,right);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
      this.preorder=preorder;
      this.inorder=inorder;
      int idx=0;
      for(Integer a : inorder){
          map.put(a,idx++);
      }
     return helper(0,preorder.length);
    }
}
