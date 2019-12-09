/*
 * @lc app=leetcode.cn id=387 lang=javascript
 *
 * [387] 字符串中的第一个唯一字符
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var firstUniqChar = function(s) {
    if (!s && s.length == 0) {
        return -1;
    }
    let sMap = new Map();
    for (let i = 0; i < s.length; i++) {
        if (sMap.has(s[i])) {
            sMap.set(s[i], sMap.get(s[i]) + 1);
        } else {
            sMap.set(s[i], 1);
        }
    }
    for (let i = 0; i < s.length; i++) {
        if (sMap.get(s[i]) == 1) {
            return i;
        }
    }
    return -1;
};
// @lc code=end

