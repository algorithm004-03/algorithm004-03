/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function(nums) {
    var n = nums.length;

    if (n === 1) {
        return nums[0];
    }
    else if (n === 0) {
        return 0;
    }

    function find(nums){
        var dp = new Array(n - 1);
        dp[0] = 0;
        dp[1] = nums[0];

        for (var i = 2; i < n; ++i) {
            dp[i] = dp[i - 1] > dp[i - 2] + nums[i - 1] ? dp[i - 1] : dp[i - 2] + nums[i - 1];
        }

        return dp[n - 1];
    }

    var num1 = find(nums.slice(1));
    var num2 = find(nums.slice(0, nums.length - 1));
    return Math.max(num1, num2);
};
