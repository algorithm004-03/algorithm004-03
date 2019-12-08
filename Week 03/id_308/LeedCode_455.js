/**
 * 题目： 分发饼干
 * 语言： JavaScript
 * 执行结果： 打败了95%的用户
 * 方法：贪心算法
 * */

/**
 * @param {number[]} g
 * @param {number[]} s
 * @return {number}
 */
var findContentChildren = function(g, s) {
    g = g.sort((a,b)=>a-b);
    s = s.sort((a,b)=>a-b);

    let count = 0;
    let ds = 0;
    let dg = 0;

    while (ds < s.length) {
        if(s[ds++] >= g[dg]) {
            count++;
            dg++;
        }
    }

    return count;
};
