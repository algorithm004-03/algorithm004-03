class Solution {
    public List<Integer> postorder(Node root) {
       List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        a(root ,ans);
        return ans;
    }
    public void a(Node root,List<Integer> ans){
        if(root != null){
            for(Node node : root.children){
                a(node,ans);
            }
            ans.add(root.val);
        }
    }
}
