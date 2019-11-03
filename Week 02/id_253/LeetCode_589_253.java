class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<Integer>();
        helper(root,ans);
        return ans;
    }
    public void helper(Node root , List<Integer> ans){
        if(root != null){
            ans.add(root.val);
            for(Node temp : root.children){
                helper(temp,ans);
            }
        }
        return;
    }
}
