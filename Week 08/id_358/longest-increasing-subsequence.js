/**
 * @param {number[]} nums
 * @return {number}
 * dp[i]: nums中前i 个最长上升子序列长度
 * for j in range(0,i) dp[i] = max(dp[j]+1,  dp[i]) if nums[i] < nums[j]
 */
var lengthOfLIS = function(nums) {
    if(nums.length === 0) return 0;
    let dp = new Array(nums.length).fill(1)
    for(let i = 0; i < nums.length; i++) {
        for (let j = 0; j < i; j++) {
            if(nums[j] < nums[i]) 
                dp[i] = Math.max(dp[i], dp[j] +1)
        }
    }
    const res = dp.sort((a,b) => a - b)
    return res[nums.length - 1];
};