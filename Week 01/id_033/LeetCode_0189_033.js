/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function(nums, k) {
  const l = nums.length;

  if (k > l - 1 || k < 1) {
    return nums;
  }

  const arr = [];

  for (let i = 0; i < l; i++) {
    if (i < l - k) {
      arr[i + k] = nums[i];
    } else {
      arr[i + k - l] = nums[i];
    }
  }

  //   console.log(arr);
  return arr;
};
