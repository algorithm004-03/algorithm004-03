// https://leetcode-cn.com/problems/group-anagrams/

/**
 * @param {string[]} strs
 * @return {string[][]}
 */
// 按排序数组分类 
// 考虑到排序的时间复杂度 所以时间复杂度是高于O(n)的
var groupAnagrams = function(strs) {
    var length = strs.length,
        charsObj = {},
        charsArr = []
    for (var i = 0; i < length; i++) {
        var key = strs[i].split('').sort().join('');
        if(charsObj[key] === undefined) charsObj[key] = [];
        charsObj[key].push(strs[i])
    }
    for (chars in charsObj) charsArr.push(charsObj[chars]);
    return charsArr;
};
console.log(groupAnagrams(["eat", "tea", "tan", "ate", "nat", "bat"]))

// 较慢的写法
var groupAnagrams = function(strs) {
    var length = strs.length,
        charsObj = {};
    for (var i = 0; i < length; i++) {
        var key = strs[i].split('').sort().join('');
        if(charsObj[key] === undefined) charsObj[key] = [];
        charsObj[key].push(strs[i])
    }
    return Object.values(charsObj);
};
