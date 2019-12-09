/*
 * @lc app=leetcode.cn id=91 lang=javascript
 *
 * [91] 解码方法
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var numDecodings = function(s) {
    if (!s || s.length == 0 || s[0] == '0') {
        return 0;
    }
    let preCount = 1;
    let prepreCount = 1;
    for (let i = 1; i < s.length; i++) {
        let curCount = 0;
        if (s[i] == '0' && (s[i - 1] == '1' || s[i - 1] == '2')) {
            curCount = prepreCount;
        } else if (s[i - 1] == '1' || (s[i - 1] == '2' && s[i] > '0' && s[i] <= '6')) {
            curCount = preCount + prepreCount;
        }
        else if (s[i] == '0' && !(s[i - 1] == '1' || s[i - 1] == '2')) {
            return 0;
        }
        else {
            curCount = preCount;
        }
        prepreCount = preCount;
        preCount = curCount;
    }
    return preCount;
};
// @lc code=end

