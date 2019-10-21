/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
var maxSlidingWindow = function(nums, k) {
    if (nums.length <= 0) {
        return [];
    }

    var result = [];

    for (var i = 0; i < nums.length - k + 1; ++i) {
        result.push(findMax(i, i + k - 1));
    }

    return result;

    function findMax(L, R){
        var max = nums[L];

        for (var i = L + 1; i <= R; ++i) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        return max;
    }
};
