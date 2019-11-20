/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function(nums) {
    var max = nums[0];
    var sum = 0;

    for(var i = 0; i < nums.length; ++i) {
        if (sum > 0) {
            sum += nums[i];
        }
        else {
            sum = nums[i];
        }

        sum > max && (max = sum);
    }

    return max;
};
