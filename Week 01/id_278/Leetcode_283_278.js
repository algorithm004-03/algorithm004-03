/**
 * 283. Move Zeroes
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function(nums) {
    if (!Array.isArray(nums)) {
        return;
    }
    
    let zero = 0;
    for (let index = 0; index < nums.length; ++ index) {
        if (nums[index] !== 0) {
            nums[zero++] = nums[index];
        }
    }
    while (zero < nums.length) {
        nums[zero++] = 0;
    }
};
