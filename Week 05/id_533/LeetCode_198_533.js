// https://leetcode-cn.com/problems/house-robber/

/**
 * @param {number[]} nums
 * @return {number}
 */
// dp状态使用二维数组记录偷窃每一个房子的可能情况
// 时间复杂度O(n) 空间复杂度O(n)
var rob = function(nums) {
    var length = nums.length,
        dp = [];
    dp[0] = [];
    dp[0][0] = 0;
    dp[0][1] = nums[0] || 0;    
    for (var i = 1; i < length; i++) {
        dp[i] = [];
        dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
        dp[i][1] = dp[i-1][0] + nums[i];
    }
    return Math.max(dp[length-1][0], dp[length-1][1]);
};

// dp状态使用两个变量记录当前房子可能的偷窃情况
// 时间复杂度O(n) 空间复杂度O(1)
var rob = function(nums) {
    var length = nums.length,
        dp1 = 0, // 不偷
        dp2 = nums[0] || 0; // 偷
    for (var i = 1; i < length; i++) {
        var tmp = dp1;
        dp1 = Math.max(dp1, dp2);
        dp2 = tmp + nums[i];
    }
    return Math.max(dp1, dp2);
};

// dp状态使用一维数组记录偷或者不偷当前房子所能得到的最大值
// 时间复杂度O(n) 空间复杂度O(1)
var rob = function(nums) {
    var length = nums.length,
        dp = [];
    dp[0] = nums[0] || 0;
    dp[1] = Math.max(nums[0], nums[1]) || 0;
    for (var i = 2; i < length; i++) {
        dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
    }
    return dp[dp.length - 1];
};

// dp状态两个变量记录前一个和当前偷或者不偷当前房子所能得到的最大值
// 时间复杂度O(n) 空间复杂度O(1)
var rob = function(nums) {
    var length = nums.length,
        prevMax = nums[0] || 0,
        curMax = Math.max(prevMax, nums[1] || 0);
    for (var i = 2; i < length; i++) {
        var tmp = curMax;
        curMax = Math.max(curMax, prevMax + nums[i])
        prevMax = tmp;
    }
    return curMax;
};

console.log(rob([1,2,3,1]));
console.log(rob([2,7,9,3,1]));
console.log(rob([]));
console.log(rob([1]));