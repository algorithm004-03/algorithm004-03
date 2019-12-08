/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function(nums) {
    if(nums.length === 0) {
        return 0;
    }

    var len = nums.length;
    var dp = new Array(len + 1);
    dp[0] = 0;
    dp[1] = nums[0];

    for (var i = 2; i <= len; ++i) {
        dp[i] = dp[i - 1] > dp[i - 2] + nums[i - 1] ? dp[i - 1] : dp[i - 2] + nums[i - 1];
    }

    return dp[len];
};
