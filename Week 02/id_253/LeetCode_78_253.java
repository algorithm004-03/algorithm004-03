class Solution {
    List<List<Integer>> ans = new LinkedList<>();
    public void dfs(int[] nums,int depth,LinkedList<Integer> curr){
        if(depth == nums.length){
            ans.add(new LinkedList(curr));
            return;
        }
        dfs(nums,depth+1,curr);
        curr.add(nums[depth]);
        dfs(nums,depth+1,curr);
        curr.removeLast();
    }
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums,0,new LinkedList<Integer>());
        return ans;
    }
}
