class Solution {
    public int jump(int[] nums) {
        int jumps=0,end=0,current=0;
        for(int i=0;i<nums.length-1;i++){
            current=Math.max(current,nums[i]+i);
            if(i==end){
                jumps++;
                end=current;
            }
        }
        return jumps;
    }
}
