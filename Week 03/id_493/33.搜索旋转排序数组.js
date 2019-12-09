/*
 * @lc app=leetcode.cn id=33 lang=javascript
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
    let len = nums.length;
    let begin = 0;
    let end = len - 1;
    while (begin <= end) {
        let mid = begin + Math.floor((end - begin) / 2);
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[begin] == target) {
            return begin;
        }
        if (target < nums[mid]) {
            if ((target > nums[begin] || nums[mid] < nums[begin])) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        } else {
            if (target > nums[end] && nums[mid] < nums[end]) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            } 
        }
    }
    return -1;
};
// @lc code=end

