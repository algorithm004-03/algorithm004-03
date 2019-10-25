/*
 * @lc app=leetcode.cn id=189 lang=javascript
 *
 * [189] 旋转数组
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function (nums, k) {
    let index = 0;
    if (k > nums.length) {
        k = k % nums.length;
    }
    index = nums.length - k;
    nums.unshift(...nums.splice(index, k))
};

let nums = [1, 2, 3, 4, 5, 6, 7]
let k = 3
rotate(nums, k)
console.log(nums)
// @lc code=end