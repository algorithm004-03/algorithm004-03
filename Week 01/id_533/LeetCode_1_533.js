// 题目 https://leetcode-cn.com/problems/two-sum/

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
// 暴力破解 时间复杂度O(n^2) 空间复杂度O(1)
var twoSum = function(nums, target) {
    var length = nums.length;
    for (var i = 0; i < length - 1; i++) {
        for (var j = 0; j < length; j++) {
            if(nums[i] + nums[j] === target) return [i, j]
        }
    }
};

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
// 使用对象快速查找 时间复杂度O(n) 空间复杂度O(n)
var twoSum = function(nums, target) {
    var length = nums.length,
        exist = {};
    for (var i = 0; i < length; i++) {
        exist[nums[i]] = i;
    }
    for(var j = 0; j < length; j++) {
        var complement = target - nums[j];
        if(exist[complement] != undefined) return [j, exist[complement]]
    }
};

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
// 使用对象实现快速查找 时间复杂度O(n) 空间复杂度O(n) --> 代码优化
var twoSum = function(nums, target) {
    var length = nums.length,
        exist = {};
    for (var i = 0; i < length; i++) {
        var complement = target - nums[i];
        if(exist[complement] != undefined) return i < exist[complement] ? [i, exist[complement]] : [exist[complement], i];
        exist[nums[i]] = i;
    }
};

var res = twoSum([2, 7, 11, 15], 13)
console.log(res)