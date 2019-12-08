class PreorderTravelsal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        preorderTraversal(root,result);
        return result;
    }
    
    public void preorderTraversal(TreeNode root, List<Integer> result){
        if(null == root){
            return;
        }else{
            result.add(root.val);
            preorderTraversal(root.left,result);
            preorderTraversal(root.right,result);
        }
    }
}