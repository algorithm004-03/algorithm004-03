// https://leetcode-cn.com/problems/permutations/

/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function(nums) {
    var result = [];
    rpermute(nums, 0);
    return result;
    function rpermute(nums, begin) {
        if (begin === nums.length - 1) {
            result.push(nums.join(',').split(','))
            return;
        }
        var origin = nums.slice(0)
        for (var i = begin; i < nums.length; i++) {
            var tmp = nums[i];
            nums[i] = nums[begin];
            nums[begin] = tmp;
            rpermute(nums, begin + 1)
            nums = origin;
        }
    }
};

console.log(permute([1, 2, 3]))


