/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
    var compare = -Infinity, total = 0;

    for (var i = 0; i < nums.length; ++i) {
        if (nums[i] !== compare) {
            nums[total++] = nums[i];
            compare = nums[i];
        }
    }

    nums.length = total;
    return total;
};
