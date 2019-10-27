/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
var merge = function(nums1, m, nums2, n) {
    for (var i = 0; i < n; ++i) {
        nums1[m + i] = nums2[i];
    }

    nums1.length = m + n;
    nums1.sort(function(a, b){ return a - b; });
    return nums1;
};
