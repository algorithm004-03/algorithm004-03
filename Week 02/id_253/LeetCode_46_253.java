class Solution {
    List<List<Integer>> ans = new LinkedList<List<Integer>>();
    public void helper(int[] nums , LinkedList<Integer> curr,int[] visited){
        if(curr.size() == nums.length) {ans.add(new LinkedList(curr)); return;}
        for(int i=0; i<nums.length ; i++){
            if(visited[i] == 1) continue;
            visited[i]=1;
            curr.add(nums[i]);
            helper(nums,curr,visited);
            visited[i]=0;
            curr.removeLast();
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        int[] visited = new int[nums.length];
        helper(nums , new LinkedList<Integer>(),visited);
        return ans;
    }
}
