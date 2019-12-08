/**
 * 1. Two Sum
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    if (!Array.isArray(nums) || nums.length < 2) {
        return [];
    }
    
    let map = {};
    
    for (let [index, num] of nums.entries()) {
        if (map[target - num] != null) {
            return [map[target - num], index];
        }
        map[num] = index;
    }
    
    return [];
};
