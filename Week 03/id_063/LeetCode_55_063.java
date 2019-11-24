/*
贪心策略
从左向右迭代，更新当前能够到达的最右边的位置，
如果能够覆盖到最后的位置，就能够到达终点

 */

class Solution {
    public boolean canJump(int[] nums) {
        int maxLen = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (maxLen >= nums.length) {
                return true;
            }

            if (i > maxLen) {
                return false;
            }

            maxLen = Math.max(i + nums[i], maxLen);
        }

        return true;
    }
}
