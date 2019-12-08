
/**
 * 题目： 2的幂
 * 语言： JavaScript
 * 执行结果： 打败了94.00%的用户
 * */



/**
 * @param {number} n
 * @return {boolean}
 */
var isPowerOfTwo = function(n) {
    return n>0 && (n & (n-1)) === 0;
};
