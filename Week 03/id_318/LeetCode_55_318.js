/*
 * @lc app=leetcode id=55 lang=javascript
 *
 * [55] Jump Game
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {boolean}
 */
var canJump = function(nums) {
    if (nums == null) return false;
    var endReachable = nums.length - 1;
    for (var i = nums.length - 1; i >= 0; i--) {
        if (nums[i] + i >= endReachable) {
            endReachable = i;
        }
    }
    return endReachable == 0;
};
// @lc code=end

