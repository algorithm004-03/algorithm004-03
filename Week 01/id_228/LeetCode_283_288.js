/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function(nums) {
  let noZeroIndex = 0;
  for (let i = 0; i < nums.length; i++) {
    if (nums[i] !== 0) {
      nums[noZeroIndex] = nums[i];
      noZeroIndex++
    }
  }
  for (let j = noZeroIndex; j < nums.length; j++) {
    nums[j] = 0;
  }
};
