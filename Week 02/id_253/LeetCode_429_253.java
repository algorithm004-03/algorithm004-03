class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>>  ans = new ArrayList<>();
        if(root == null) return ans;
        ans.add(new ArrayList(root.val));
        a(root,0,ans);
        return ans;
    }
    public void a(Node root ,int depth, List<List<Integer>> ans){
        if(root == null) return ;
        if(depth +1 >ans.size()) ans.add(new ArrayList<>());
        ans.get(depth).add(root.val);
        for(Node node : root.children){
                a(node,depth+1,ans);
        }
    }
}
