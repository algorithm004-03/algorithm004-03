/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for(int i=0;i<nums.length-1;i++){
            //找出nums[i]+i最大的，即能跳最远的
            maxPosition = Math.max(maxPosition, nums[i]+i);
            if(i==end){
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
// @lc code=end

