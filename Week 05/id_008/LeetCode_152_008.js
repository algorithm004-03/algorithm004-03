/**
 * @param {number[]} nums
 * @return {number}
 */
var maxProduct = function(nums) {
    var dpMax = new Array(nums.length);
    var dpMin = new Array(nums.length);
    dpMax[0] = nums[0];
    dpMin[0] = nums[0];

    var max = dpMax[0];

    for(var i = 1; i < nums.length; ++i){
        dpMax[i] = Math.max(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i], nums[i]);
        dpMin[i] = Math.min(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i], nums[i]);
        dpMax[i] > max && (max = dpMax[i]);
    }

    return max;
};
