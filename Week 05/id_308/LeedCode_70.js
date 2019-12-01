/**
 * 题目： 爬楼梯
 * 语言： JavaScript
 * 执行结果： 打败了95.64%的用户
 * 方法：动态规划
 * */

/**
 * @param {number} n
 * @return {number}
 */
const climbStairs = function(n) {
    const result = [1,1,2];
    let i = 3;

    while(i <= n) {
        result[i] = result[i-1] + result[i-2];
        i++;
    }

    return result[n];
};
