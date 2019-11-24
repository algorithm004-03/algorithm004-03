// https://leetcode-cn.com/problems/assign-cookies/

/**
 * @param {number[]} g
 * @param {number[]} s
 * @return {number}
 */
var findContentChildren = function(g, s) {
    var gi = 0,
        si = 0;
    g.sort(function(a, b) {return a - b});
    s.sort(function(a, b) {return a - b});
    while (gi < g.length && si < s.length) {
        if (s[si] >= g[gi]) gi++;
        si++
    }
    return gi;
};

console.log(findContentChildren([1, 2], [1, 2, 3]));
console.log(findContentChildren([10,9,8,7], [5,6,7,8]));