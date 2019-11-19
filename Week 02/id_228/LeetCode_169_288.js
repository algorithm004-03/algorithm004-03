
// 解法一，排序后去中间值
/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function(nums) {
    if (nums.length === 0) {
        return null
    }
    let halfPositin = Math.floor(nums.length / 2)
    let sortNums = nums.sort()
    return sortNums[halfPositin]
};
