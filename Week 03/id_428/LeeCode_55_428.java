
class Solution {
    //No.1 Ok
    public boolean canJump(int[] nums) {
        int max = 0;
        for(int i=0;i<nums.length;i++){
            if(i>max) {return false;}
            max = Math.max(nums[i]+i,max);
        }
        return true;
    }

    //No2.Time Limit Exceeded
//public boolean canJumpFromPosition(int position, int[] nums) {
//    if (position == nums.length - 1) {
//        return true;
//    }
//    int furthestJump = Math.min(position + nums[position], nums.length - 1);
////    for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
//    for (int nextPosition = furthestJump; nextPosition > position; nextPosition--) {
//        if (canJumpFromPosition(nextPosition, nums)) {
//
//            return true;
//        }
//    }
//    return false;
//}
//    public boolean canJump(int[] nums) {
//        return canJumpFromPosition(0, nums);
//    }
	
}