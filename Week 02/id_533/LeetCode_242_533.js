// https://leetcode-cn.com/problems/valid-anagram/description/

/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
// 暴力求解
var isAnagram = function(s, t) {
    if (s.length !== t.length) return false;
    return s.split('').sort().join('') === t.split('').sort().join('');
};

/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
// 哈希表(针对只有字母的字符串)
// 时间复杂度O(n) 空间复杂度O(1)
var isAnagram = function(s, t) {
    if (s.length !== t.length) return false;
    var length = s.length,
        charCount = new Array(26).fill(0)
    for (var i = 0; i < length; i++) {
        charCount[s[i].charCodeAt() - 97]++;
        charCount[t[i].charCodeAt() - 97]--;
    }
    for(var count in charCount) {
        if (charCount[count] !== 0) return false;
    }
    return true;
};

/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
// 哈希表(通用)
// 时间复杂度O(n) 空间复杂度O(1)
var isAnagram = function(s, t) {
    if (s.length !== t.length) return false;
    var length = s.length,
    charCount = {};
    for (var i = 0; i < length; i++) charCount[s[i]] = charCount[s[i]] ? ++charCount[s[i]] : 1;
    for (var i = 0; i < length; i++) charCount[t[i]] = charCount[t[i]] ? --charCount[t[i]] : 1;
    for (count in charCount) if(charCount[count] !== 0) return false;
    return true;
};

console.log(isAnagram('anagram', 'nagaram'));
console.log(isAnagram('rat', 'car'));