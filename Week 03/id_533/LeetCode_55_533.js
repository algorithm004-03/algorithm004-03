// https://leetcode-cn.com/problems/jump-game/

/**
 * @param {number[]} nums
 * @return {boolean}
 */
// 贪心
// 时间复杂度O(n) 空间复杂度O(1)
var canJump = function(nums) {
    var lastPos = nums.length - 1;
    for (var i = nums.length - 2; i >= 0; i--) {
        if (i + nums[i] >= lastPos) lastPos = i;
    }
    return lastPos === 0;
};

lastPos = 1

// 0, 1
// 2, 0

console.log(canJump([2, 3, 1, 1, 4]))
console.log(canJump([3, 2, 1, 0, 4]))
console.log(canJump([2, 0]))