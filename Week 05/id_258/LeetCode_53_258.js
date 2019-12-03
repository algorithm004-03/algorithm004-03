/*
 * @lc app=leetcode.cn id=53 lang=javascript
 *
 * [53] 最大子序和
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function(nums) {
    let dp = nums;

    for(let i = 1; i < nums.length; i++) {
        dp[i] = Math.max(dp[i-1], 0) + dp[i];
    }
    return Math.max.apply(null,dp);
};
// @lc code=end

