/*
 * @lc app=leetcode.cn id=191 lang=javascript
 *
 * [191] 位1的个数
 */

// @lc code=start
/**
 * @param {number} n - a positive integer
 * @return {number}
 */
var hammingWeight = function(n) {
    let rs = 0;
    while(n != 0) {
        rs = rs + 1;
        n = n & (n - 1);
    }
    return rs;
};
// @lc code=end

