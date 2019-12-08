// https://leetcode-cn.com/problems/combinations/

/**
 * @param {number} n
 * @param {number} k
 * @return {number[][]}
 */
// 递归
var combine = function(n, k) {
    var res = []
    rcombine(n, k, 1, [])
    return res
    function rcombine (n, k, l, pre) {
        if (pre.length === k) {
            res.push(pre)
            return
        }
        for (var i = l; i <= n - (k - pre.length) + 1; i++) {
            rcombine(n, k, i + 1, pre.concat([i]))
        }
    }
};

console.log(combine(4, 4));