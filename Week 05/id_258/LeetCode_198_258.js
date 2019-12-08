/*
 * @lc app=leetcode.cn id=198 lang=javascript
 *
 * [198] 打家劫舍
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function (nums) {
    if (!nums || nums.length === 0) return false;

    let n = nums.length;

    let a = [
        [],
        []
    ];

    a[0][0] = 0;
    a[1][0] = nums[0];

    for (let i = 1; i < nums.length; i++) {
        a[0][i] = Math.max(a[1][i - 1], a[0][i - 1]);
        a[1][i] = a[0][i - 1] + nums[i];
    }

    return Math.max(a[0][n - 1], a[1][n - 1]);

};
// @lc code=end