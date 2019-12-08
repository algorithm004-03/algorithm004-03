// 题目 https://leetcode-cn.com/problems/climbing-stairs/

/**
 * @param {number} n
 * @return {number}
 */
// 暴力破解法 时间复杂度O(2^n) 空间复杂度O(n)
var climbStairs = function (n) {
    if (n < 3) return n;
    return climbStairs(n - 1) + climbStairs(n - 2)
};

/**
 * @param {number} n
 * @return {number}
 */
// 暴力破解法的时间复杂度太高了 可以进行优化 缓存已经计算过的结果
// 此时，时间复杂度O(n) 空间复杂度O(n)
// 优化过后在Leetc上运行 n比较大时会出现误差-->内存溢出
// 老师的解答：解法方法就是高精度类型，类似java里的 BigInt 和 BigDecimal，底层实现就是维护一个数组来模拟非常大的数字的运算
// https://zhuanlan.zhihu.com/p/56193640
// https://leetcode-cn.com/problems/plus-one/(做完回来写感想)
var climbStairs = function (n) {
    var caches = [];
    return climbing(n)
    function climbing (n) {
        if (n < 3) return n;
        if (caches[n]) return caches[n];
        caches[n] = climbing(n - 1) + climbing(n - 2);
        return caches[n];
    }
};

/**
 * @param {number} n
 * @return {number}
 */
// 斐波那契数列的非递归解法
// 时间复杂度O(n) 空间复杂度O(1)
var climbStairs = function (n) {
    if (n < 3) return n;
    var first = 1;
    var second = 2;
    for (var i = 3; i <= n; i++) {
        var third = first + second;
        first = second;
        second = third;
    }
    return second;
};

var result = climbStairs(10)
console.log(result)
