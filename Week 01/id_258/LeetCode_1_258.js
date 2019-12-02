/*
 * @lc app=leetcode.cn id=1 lang=javascript
 *
 * [1] 两数之和
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function (nums, target) {
    for (let i = 0; i < nums.length; i++) {
        let j = nums.indexOf(target - nums[i])
        if (j !== -1 && i !== j) {
            return [i, j]
        }
    }
    return []
};
// var twoSum = function (nums, target) {
//     // 利用哈希表的key值唯一的特性
//     // 升维操作 空间换时间
//     let memory = new Map();
//     for (let i = 0; i < nums.length; i++) {
//         if (memory.has(target - nums[i])) {
//             return [memory.get(target - nums[i]), i];
//         } else {
//             memory.set(nums[i], i);
//         }
//     }
//     return []
// };
// @lc code=end