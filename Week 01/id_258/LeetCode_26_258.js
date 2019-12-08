/*
 * @lc app=leetcode.cn id=26 lang=javascript
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
// var removeDuplicates = function (nums) {
//     let memory = new Map();
//     for (let i = 0; i < nums.length; i++) {
//         if (!memory.has(nums[i])) {
//             memory.set(nums[i])
//         }
//     }
//     return memory.size;
// };
var removeDuplicates = function (nums) {
    // let deletIndex = [];
    let index = 0;
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] != nums[index]) {
            nums[++index] = nums[i]
        }
    }
    nums.splice(index, nums.length - ++index)
    return index;
};
let nums = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
console.log(removeDuplicates(nums))
console.log(nums)
// @lc code=end