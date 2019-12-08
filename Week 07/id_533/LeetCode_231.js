// https://leetcode-cn.com/problems/power-of-two/

/**
 * @param {number} n
 * @return {boolean}
 */
var isPowerOfTwo = function(n) {
    return n > 0 && (n & (n - 1)) == 0;
};

console.log(isPowerOfTwo(1));
console.log(isPowerOfTwo(16));
console.log(isPowerOfTwo(218));