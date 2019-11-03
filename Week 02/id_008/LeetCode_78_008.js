/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsets = function(nums) {
    var k = 1 << nums.length;
    var result = [];

    for (var i = 0; i < k; ++i) {
        var answer = [];

        for (j = 0; j < nums.length; ++j) {
            if (i >> j & 1) {
                answer.push(nums[j]);
            }
        }

        result.push(answer);
    }

    return result;
};
