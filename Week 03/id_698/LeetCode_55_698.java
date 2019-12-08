/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 * @author gning (id=698)
 */

public class LeetCode_55_698 {

    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) {
            return true;
        }

        int reachable = nums.length - 1;

        for(int i=nums.length-1; i>=0; i--) {
            if(nums[i] + i >= reachable )  {
                reachable = i;
            }
        }

        return reachable == 0;

    }
    
}