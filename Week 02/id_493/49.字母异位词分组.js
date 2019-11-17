/*
 * @lc app=leetcode.cn id=49 lang=javascript
 *
 * [49] 字母异位词分组
 */

// @lc code=start
/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
    let sObj = {};
    for (let str of strs) {
        let key = Array.from(str).sort().toString();
        sObj[key] = sObj[key] || [];
        sObj[key].push(str);
    }
    let result = [];
    for (let key in sObj) {
        result.push(sObj[key]);
    }
    return result;
};
// @lc code=end

