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
var isAnagram = function (s, t) {
    // let sList = s.split("").sort()
    // let tList = t.split("").sort()
    // if (sList.length !== tList.length) return false;
    // return sList.every((ele, index, array) => {
    //     return ele === tList[index]
    // })
    return s.split("").sort().join("") === t.split("").sort().join("")

};

// var isAnagram = function (s, t) {
//     const map = {};
//     s.split("").map(item => map[item] = map[item] ? map[item] + 1 : 1);
//     t.split("").map(item => map[item] = map[item] ? map[item] - 1 : -1);

//     return Object.keys(map).every(key => map[key] === 0);
// };

console.log(isAnagram('a', 'ab'))
// @lc code=end