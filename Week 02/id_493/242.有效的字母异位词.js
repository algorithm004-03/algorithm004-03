/*
 * @lc app=leetcode.cn id=242 lang=javascript
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
    if (s.length !== t.length) {
        return false;
    }
    let numObj = {};
    for (let a of s) {
        if (numObj.hasOwnProperty(a)) {
            numObj[a] = numObj[a] + 1;
        } else {
            numObj[a] = 1;
        }
    }
    for (let a of t) {
        if (numObj.hasOwnProperty(a)) {
            numObj[a] = numObj[a] - 1;
            if (numObj[a] < 0) {
                return false;
            }
        } else {
            return false;
        }
    }
    return true;
};
// @lc code=end

