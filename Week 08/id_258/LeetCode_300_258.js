/*
 * @lc app=leetcode.cn id=300 lang=javascript
 *
 * [300] 最长上升子序列
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var lengthOfLIS = function (nums) {
    let lis = [];
    for (let i = 0; i < nums.length; i++) {
        lis.push(1);
        for (let j = 0; j < i; j++) {
            if (nums[j] < nums[i]) lis[i] = Math.max(lis[i], lis[j] + 1);
        }
    }

    return nums.length ? Math.max.apply(null, lis) : 0;
};
// @lc code=end

