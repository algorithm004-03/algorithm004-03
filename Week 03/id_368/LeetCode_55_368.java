public class LeetCode_55_368 {

    /*给定一个非负整数数组，你最初位于数组的第一个位置。
    数组中的每个元素代表你在该位置可以跳跃的最大长度。
    判断你是否能够到达最后一个位置。*/

    public static void main(String[] args) {

    }

    public boolean canJump(int[] nums) {
        int[] memo = new int[nums.length];
        memo[memo.length - 1] = 1;
        return canJumpPosition(0, nums, memo);
    }

    public boolean canJumpPosition (int position, int[] nums, int[] memo) {
        if (memo[position] != 0) {
            if (memo[position] == 1) {
                return true;
            }
            return false;
        }
        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpPosition(nextPosition, nums, memo)) {
                memo[position] = 1;
                return true;
            }
        }
        memo[position] = 2;
        return false;
    }

    public boolean canJump02(int[] nums) {
        int lastPosition = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i >= lastPosition) {
                lastPosition = i;
            }
        }
        return lastPosition == 0;
    }
}
