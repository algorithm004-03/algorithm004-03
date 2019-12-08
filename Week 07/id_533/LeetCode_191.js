// https://leetcode-cn.com/problems/number-of-1-bits/

/**
 * @param {number} n
 * @return {number}
 */
// 取模判断再左移
var hammingWeight = function(n) {
    var count = 0;
    while (n) {
        if (n & 1 == 1)
            count++;
        n = n >>> 1;
    }
    return count;
};

/**
 * @param {number} n
 * @return {number}
 */
// 打掉最低位的1
var hammingWeight = function(n) {
    var count = 0;
    while (n) {
        count++;
        n = n & (n-1);
    }
    return count;
};

console.log(hammingWeight(00000000000000000000000000001011))
console.log(hammingWeight(00000000000000000000000010000000))
console.log(hammingWeight(11111111111111111111111111111101))