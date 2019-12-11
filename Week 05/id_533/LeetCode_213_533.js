// https://leetcode-cn.com/problems/house-robber-ii/

/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function (nums) {
    var max1 = r(nums);
    var max2 = r(nums.concat([]).reverse());
    return Math.max(max1, max2);
    function r (nums) {
        if (nums.length === 0) return 0;
        if (nums.length === 1) return nums[0];
        var prevMax = 0,
            curMax = nums[1];
        for (var i = 2; i < nums.length; i++) {
            var tmp = curMax;
            curMax = Math.max(curMax, prevMax + nums[i]);
            prevMax = tmp;
        }
        return curMax;
    }
};

console.log(rob([2, 3, 2]));
console.log(rob([1, 2, 3, 1]));