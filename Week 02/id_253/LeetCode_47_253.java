class Solution {
    private List<List<Integer>> ans = new LinkedList<>();
    private boolean[] used;
    public void backtrack(int[] nums, LinkedList<Integer> curr){
        if(curr.size() == nums.length) {
            ans.add(new LinkedList(curr));
            return;
        }
        for(int i=0;i<nums.length ; i++){
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
            if(used[i] == true) continue;
            used[i] = true;
            curr.add(nums[i]);
            backtrack(nums,curr);
            used[i]=false;
            curr.removeLast();
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums.length == 0) return ans;
        Arrays.sort(nums);
        used=new boolean[nums.length];
        backtrack(nums,new LinkedList<Integer>());
        return ans;
    }
}

