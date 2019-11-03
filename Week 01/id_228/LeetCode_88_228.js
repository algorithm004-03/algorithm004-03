/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
var merge = function(nums1, m, nums2, n) {
  let tempNums1 = nums1.slice(0, m);
  let tempNums2 = nums2.slice(0, n);
  Object.assign(nums1, tempNums1.concat(tempNums2).sort((a, b) => a - b));
};
