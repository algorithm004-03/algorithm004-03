/*
 * @lc app=leetcode.cn id=55 lang=csharp
 *
 * [55] 跳跃游戏
 */

// @lc code=start
public class Solution {
    public bool CanJump(int[] nums) {
        int canReachable = nums.Length-1;
        for (int i = nums.Length-1; i >=0; i--)
        {
            if(nums[i]+i>=canReachable){
                canReachable = i;
            }
        }
        return canReachable==0;
    }
}
// @lc code=end

