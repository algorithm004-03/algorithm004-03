// https://leetcode-cn.com/problems/maximum-product-subarray/

/**
 * @param {number[]} nums
 * @return {number}
 */
// 本题关键 负数乘以较小的数反而会更大
// dp状态存储当前最大正值和最小负值
var maxProduct = function(nums) {
    var length = nums.length,
        dp1 = nums[0],
        dp2 = nums[0],
        max = nums[0];
    for (var i = 1; i < length; i++) {
        if (nums[i] < 0) {
            var tmp = dp1;
            dp1 = dp2;
            dp2 = tmp;
        }
        dp1 = Math.max(dp1 * nums[i], nums[i]);
        dp2 = Math.min(dp2 * nums[i], nums[i]);
        max = Math.max(max, dp1);
    }
    return max;
};

console.log(maxProduct([2, 3, -2, 4]))
console.log(maxProduct([2, 3, -2, 4, -2]))
console.log(maxProduct([2, 3, -2, 4, -2, -60]))