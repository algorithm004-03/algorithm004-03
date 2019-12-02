/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function(nums, k) {
    for (var i = 0; i < k; ++i) {
        nums.unshift(nums.pop());
    }

    return nums;
};

/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function(nums, k) {
    while (k >= nums.length) {
        k -= nums.length;
    }

    var len = nums.length;
    var clone = nums.slice(0);
    clone = clone.concat(clone.slice(0));

    for (var i = 0; i < len; ++i) {
        nums[i] = clone[len + i - k];
    }

    return nums;
};
