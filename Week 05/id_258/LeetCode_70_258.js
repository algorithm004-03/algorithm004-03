/*
 * @lc app=leetcode.cn id=70 lang=javascript
 *
 * [70] 爬楼梯
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function (n) {
    // 记忆化搜索
    var memo = []
    var fib = function(n) {
        if(n===1 || n===2) return n;

        if(!memo[n]) {
            memo[n] = fib(n - 1) + fib(n - 2)
        }
        return memo[n]
    }
    return fib(n)
};

climbStairs(4)
// @lc code=end