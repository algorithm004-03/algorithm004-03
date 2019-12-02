class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 0) return false;
        int reach=nums.length-1;
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]+i>=reach) reach=i;
        }
        return reach==0;
    }
}
