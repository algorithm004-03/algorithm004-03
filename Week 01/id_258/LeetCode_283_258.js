/*
 * @lc app=leetcode.cn id=283 lang=javascript
 *
 * [283] 移动零
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function (nums) {
    // 找到目标数组0项的开始下标
    let zeroIndex = 0;
    for (let i = 0; i < nums.length; i++) {
        if (nums[i]) {
            nums[zeroIndex++] = nums[i];
        }
    }

    // 将数组末端为0的元素置0
    for (let i = zeroIndex; i < nums.length; i++) {
        nums[i] = 0;
    }
};

// var moveZeroes = function (nums) {
//     for (let i = nums.length; i--;) {
//         if (nums[i] === 0) {
//             nums.splice(i, 1);
//             nums.push(0);
//         }
//     }
//     return nums;
// }
// @lc code=end