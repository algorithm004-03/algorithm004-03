// https://leetcode-cn.com/problems/reverse-bits/
// JS对于整数的位运算仅支持32位有符号整数

/**
 * @param {number} n - a positive integer
 * @return {number} - a positive integer
 */
var reverseBits = function(n) {
    var ans = 0;
    for (var i = 0; i < 32; i++) {
        ans = (ans << 1) | (n & 1);
        n >>= 1;
    }
    return ans >>> 0;
};
