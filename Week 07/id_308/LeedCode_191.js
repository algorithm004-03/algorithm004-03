/**
 * 题目： 位1的个数
 * 语言： JavaScript
 * 执行结果： 打败了73.09%的用户
 * */

/**
 * @param {number} n - a positive integer
 * @return {number}
 */
var hammingWeight = function(n) {
    let count = 0;
    while(n) {
        n&=(n-1);
        count++;
    }

    return count;
};
