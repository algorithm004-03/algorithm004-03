/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function(nums) {
    var total = [];
    var max = 0;
    var result = 0;

    for (var i = 0; i < nums.length; ++i) {
        if (typeof total[nums[i]] === "undefined") {
            total[nums[i]] = 0;
        }

        ++total[nums[i]];

        if (total[nums[i]] > max) {
            max = total[nums[i]];
            result = nums[i]
        }
    }

    return result;
};
