// https://leetcode-cn.com/problems/generate-parentheses/

/**
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function(n) {
    var result = []
    generate(0, 0, n, '')
    return result;
    function generate(left, right, n, s) {
        if (left === n && right ==n) {
            result.push(s);
            return;
        }
        if(left < n) generate(left + 1, right, n, s + '(');
        if(left > right) generate(left, right + 1, n, s + ')');
    }
};

var result = generateParenthesis(3);
console.log(result);