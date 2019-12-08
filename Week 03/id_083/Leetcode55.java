/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        //从数组右边向左边迭代
        //eg:如果num【mid】可以跳到num【last】，lastPos = mid；继续，能找到num【0】结束
        int lastPos = nums.length -1;
        for(int i = nums.length -1;i>=0;i--){
            if(i + nums[i] >= lastPos){
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}
// @lc code=end

