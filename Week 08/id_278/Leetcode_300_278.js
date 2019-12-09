/**
 * @param {number[]} nums
 * @return {number}
 */
var lengthOfLIS = function(nums) {
    var f = new Array(nums.length);
    var max = 0;
    var i, j;
    for (i = 0; i < nums.length; i++) {
        f[i] = 1;
        for (j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
                f[i] = f[i] > f[j] + 1 ? f[i] : f[j] + 1;
            }
        }
        if (f[i] > max) {
            max = f[i];
        }
    }
    return max;
};
