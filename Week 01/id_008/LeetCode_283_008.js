/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function(nums) {
    var target = 0, i;

    for (i = 0; i < nums.length; ++i) {
        if (nums[i] !== 0) {
            nums[target] = nums[i];
            target++ === i || (nums[i] = 0);
        }
    }

    return nums;
};
