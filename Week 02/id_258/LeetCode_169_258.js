/*
 * @lc app=leetcode.cn id=169 lang=javascript
 *
 * [169] 求众数
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function (nums) {
    let map = {}
    for (let i = 0; i < nums.length; i++) {
        map[nums[i]] = map[nums[i]] + 1 || 1;
        if (map[nums[i]] > nums.length / 2) return nums[i];
    }
};
// @lc code=end