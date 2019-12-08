/*
 * @lc app=leetcode id=190 lang=javascript
 *
 * [190] Reverse Bits
 */

// @lc code=start
/**
 * @param {number} n - a positive integer
 * @return {number} - a positive integer
 */
var reverseBits = function(n) {
    let reverse_n = 0;
    for (let i = 0; i < 32; ++i) {
        reverse_n = (reverse_n << 1) + (n & 1);
        n >>= 1;
    }
    return reverse_n >>> 0;
};
// @lc code=end

